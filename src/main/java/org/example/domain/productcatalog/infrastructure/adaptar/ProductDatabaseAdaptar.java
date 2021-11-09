package org.example.domain.productcatalog.infrastructure.adaptar;

import lombok.AllArgsConstructor;
import org.example.domain.productcatalog.core.model.Product;
import org.example.domain.productcatalog.core.ports.outgoing.ProductDatabase;
import org.example.domain.productcatalog.infrastructure.adaptar.repository.ProductRepository;

import java.util.Optional;

@AllArgsConstructor
public class ProductDatabaseAdaptar implements ProductDatabase {

    private final ProductRepository productRepository;

    @Override
    public Optional<Product> getProduct(String sellProductName) {
        return productRepository.findById(sellProductName);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
