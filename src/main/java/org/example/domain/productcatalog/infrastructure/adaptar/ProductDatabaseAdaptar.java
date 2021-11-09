package org.example.domain.productcatalog.infrastructure.adaptar;

import lombok.AllArgsConstructor;
import org.example.domain.productcatalog.core.model.Product;
import org.example.domain.productcatalog.core.ports.outgoing.ProductDatabase;
import org.example.domain.productcatalog.infrastructure.adaptar.repository.ProductRepository;
import org.example.domain.productcatalog.infrastructure.adaptar.repository.entity.ProductEntity;

import java.util.Optional;

@AllArgsConstructor
public class ProductDatabaseAdaptar implements ProductDatabase {

    private final ProductRepository productRepository;

    @Override
    public Optional<Product> getProduct(String sellProductName) {


        Optional<ProductEntity> result = productRepository.findById(sellProductName);
        return result.map(ProductEntity::getProductDomain);
    }

    @Override
    public Product saveProduct(Product product) {

        ProductEntity savedEntity = productRepository.save(ProductEntity.fromProductDomain(product));
        return savedEntity.getProductDomain();
    }
}
