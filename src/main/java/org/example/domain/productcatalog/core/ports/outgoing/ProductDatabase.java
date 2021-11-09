package org.example.domain.productcatalog.core.ports.outgoing;

import org.example.domain.productcatalog.core.model.Product;

import java.util.Optional;

public interface ProductDatabase {

    Optional<Product> getProduct(String productName);

    Product saveProduct(Product product);
}
