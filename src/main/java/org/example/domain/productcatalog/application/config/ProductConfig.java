package org.example.domain.productcatalog.application.config;

import org.example.domain.productcatalog.core.ports.ProductFacade;
import org.example.domain.productcatalog.core.ports.incoming.AddNewProducts;
import org.example.domain.productcatalog.core.ports.incoming.SellProduct;
import org.example.domain.productcatalog.core.ports.incoming.UpdateProductStatus;
import org.example.domain.productcatalog.core.ports.outgoing.ProductAddEventPublisher;
import org.example.domain.productcatalog.core.ports.outgoing.ProductDatabase;
import org.example.domain.productcatalog.core.ports.outgoing.ProductSaleEventPublisher;
import org.example.domain.productcatalog.infrastructure.adaptar.ProductDatabaseAdaptar;
import org.example.domain.productcatalog.infrastructure.adaptar.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    public ProductDatabase getProductDatabase(final ProductRepository productRepository) {
        return new ProductDatabaseAdaptar(productRepository);
    }

    //ProductFacade implements SellProduct, AddNewProducts, UpdateProductStatus

    @Bean
    public SellProduct sellProduct(final ProductDatabase productDatabase,
                                      final ProductSaleEventPublisher productSaleEventPublisher,
                                      final ProductAddEventPublisher productAddEventPublisher) {
        return new ProductFacade(productDatabase, productSaleEventPublisher, productAddEventPublisher);

    }

    @Bean
    public AddNewProducts addNewProducts(final ProductDatabase productDatabase,
                                           final ProductSaleEventPublisher productSaleEventPublisher,
                                           final ProductAddEventPublisher productAddEventPublisher) {
        return new ProductFacade(productDatabase, productSaleEventPublisher, productAddEventPublisher);

    }

    @Bean
    public UpdateProductStatus updateProductStatus(final ProductDatabase productDatabase,
                                                   final ProductSaleEventPublisher productSaleEventPublisher,
                                                   final ProductAddEventPublisher productAddEventPublisher) {
        return new ProductFacade(productDatabase, productSaleEventPublisher, productAddEventPublisher);

    }

}
