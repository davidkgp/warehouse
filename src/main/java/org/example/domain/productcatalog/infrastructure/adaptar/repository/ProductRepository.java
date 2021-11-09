package org.example.domain.productcatalog.infrastructure.adaptar.repository;

import org.example.domain.productcatalog.core.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
