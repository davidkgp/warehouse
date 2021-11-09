package org.example.domain.productcatalog.core.ports;

import lombok.AllArgsConstructor;
import org.example.domain.productcatalog.core.model.AssociatedArticle;
import org.example.domain.productcatalog.core.model.Product;
import org.example.domain.productcatalog.core.model.ProductStatus;
import org.example.domain.productcatalog.core.model.command.AddProductCommand;
import org.example.domain.productcatalog.core.model.command.SellCommand;
import org.example.domain.productcatalog.core.model.command.UpdateProductStatusCommand;
import org.example.domain.productcatalog.core.model.event.ProductAddEvent;
import org.example.domain.productcatalog.core.model.event.ProductSoldEvent;
import org.example.domain.productcatalog.core.model.output.AddProductsOutput;
import org.example.domain.productcatalog.core.model.output.SellOutput;
import org.example.domain.productcatalog.core.ports.incoming.AddNewProducts;
import org.example.domain.productcatalog.core.ports.incoming.SellProduct;
import org.example.domain.productcatalog.core.ports.incoming.UpdateProductStatus;
import org.example.domain.productcatalog.core.ports.outgoing.ProductAddEventPublisher;
import org.example.domain.productcatalog.core.ports.outgoing.ProductDatabase;
import org.example.domain.productcatalog.core.ports.outgoing.ProductSaleEventPublisher;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ProductFacade implements SellProduct, AddNewProducts, UpdateProductStatus {

    private final ProductDatabase productDatabase;
    private final ProductSaleEventPublisher productSaleEventPublisher;
    private final ProductAddEventPublisher productAddEventPublisher;


    @Override
    public Optional<SellOutput> handle(final SellCommand sellCommand) {

        Optional<Product> productResult = productDatabase.getProduct(sellCommand.getSellProductName());

        return productResult
                .map(product -> {
                    Product updated = product
                            .sellStock(sellCommand.getSellQuantity())
                            .updateStatusIfSoldOut();
                    productDatabase.saveProduct(updated);
                    productSaleEventPublisher.publish(ProductSoldEvent
                            .fromSaleDetails(
                                    product.getProductName()
                                    , sellCommand.getSellQuantity()
                                    , product.getAssociatedArticles()));
                    return new SellOutput(String.format("%s of %s product sold", sellCommand.getSellQuantity(), sellCommand.getSellProductName()));
                });

    }

    @Override
    public AddProductsOutput handle(final AddProductCommand addProductCommand) {


        List<Product> savedProducts = addProductCommand
                .getProducts()
                .stream()
                .map(productWithStock -> {
                    Optional<Product> productResult = productDatabase.getProduct(productWithStock.getValue0().getProductName());
                    return productResult.map(productinDB ->
                            //chance to update the article association, not implemented
                            productinDB
                                    .addStock(productWithStock.getValue1())

                    ).orElse(Product
                            .initializeWithStock(
                                    productWithStock.getValue0().getProductName()
                                    , productWithStock
                                            .getValue0()
                                            .getContainingArticlesList()
                                            .stream()
                                            .map(containingArticle -> new AssociatedArticle(containingArticle.getId(), containingArticle.getQuantity()))
                                            .collect(Collectors.toSet())
                                    , productWithStock.getValue1()
                            ));

                })
                .map(updatedProduct -> updatedProduct.updateStatus(ProductStatus.UPLOADED_CHECKING_ARTICLE_STOCK))
                .map(productDatabase::saveProduct)
                .collect(Collectors.toList());

        savedProducts.forEach(savedProduct -> productAddEventPublisher.publish(ProductAddEvent.fromProductAdd(savedProduct.getProductName()
                , savedProduct.getStockQuantity()
                , savedProduct.getAssociatedArticles())));


        int stockAddedCount = savedProducts.size();


        return new AddProductsOutput(stockAddedCount, 0);
    }

    @Override
    public void handle(final UpdateProductStatusCommand updateProductStatusCommand) {

        Optional<Product> productResult = productDatabase.getProduct(updateProductStatusCommand.getProductName());

        productResult
                .map(product -> product.updateStatus(updateProductStatusCommand.getProductStatus()))
                .ifPresent(productDatabase::saveProduct);

    }
}
