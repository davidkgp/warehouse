package org.example.domain.productcatalog.core.ports.outgoing;

import org.example.domain.productcatalog.core.model.Product;

import java.util.Optional;

public interface ProductDatabase {


    Optional<Product> getProduct(String sellProductName);

    void saveProduct(Product product);
}
