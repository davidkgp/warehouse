package org.example.domain.productcatalog.core.ports.incoming;

import org.example.domain.productcatalog.core.model.Product;

import java.util.Optional;


public interface GetProduct {
    Optional<Product> handle(String productName);
}
