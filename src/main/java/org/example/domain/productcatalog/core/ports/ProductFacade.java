package org.example.domain.productcatalog.core.ports;

import lombok.AllArgsConstructor;
import org.example.domain.productcatalog.core.model.Product;
import org.example.domain.productcatalog.core.model.ProductStatus;
import org.example.domain.productcatalog.core.model.command.AddProductCommand;
import org.example.domain.productcatalog.core.model.command.SellCommand;
import org.example.domain.productcatalog.core.model.output.AddProductsOutput;
import org.example.domain.productcatalog.core.model.output.SellOutput;
import org.example.domain.productcatalog.core.ports.incoming.AddNewProducts;
import org.example.domain.productcatalog.core.ports.incoming.SellProduct;
import org.example.domain.productcatalog.core.ports.outgoing.ProductDatabase;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ProductFacade implements SellProduct, AddNewProducts {

    private ProductDatabase productDatabase;


    @Override
    public Optional<SellOutput> handle(final SellCommand sellCommand) {

        Optional<Product> productResult = productDatabase.getProduct(sellCommand.getSellProductName());

        return productResult
                .map(product -> {
                    Product updated = product
                            .sellStock(sellCommand.getSellQuantity())
                            .updateStatusIfSoldOut();
                    productDatabase.saveProduct(updated);
                    //TODO send an event to update the article count
                    return new SellOutput(String.format("%s of %s product sold", sellCommand.getSellQuantity(), sellCommand.getSellProductName()));
                });

    }

    @Override
    public AddProductsOutput handle(final AddProductCommand products) {


        List<Integer> stockAdded = products
                .getProducts()
                .entrySet()
                .stream()
                .map(productLineLongEntry -> {
                    final Optional<Product> productResult = productDatabase
                            .getProduct(productLineLongEntry.getKey().getProductName());
                    return productResult.map(product -> {
                        Product updated = product
                                .addStock(productLineLongEntry.getValue())
                                .updateStatus(ProductStatus.UPLOADED);
                        productDatabase.saveProduct(updated);
                        //TODO send an event to update the article count
                        return productLineLongEntry.getValue();
                    }).orElseGet(() -> -1 * productLineLongEntry.getValue());


                }).collect(Collectors.toList());

        int stockAddedCount = stockAdded.stream().filter(value -> value > 0).reduce(0, Integer::sum);
        int stockNotAddedCount = stockAdded.stream().filter(value -> value < 0).reduce(0, Integer::sum);


        return new AddProductsOutput(stockAddedCount, stockNotAddedCount);
    }
}
