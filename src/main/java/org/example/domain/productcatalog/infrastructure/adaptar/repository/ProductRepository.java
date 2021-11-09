package org.example.domain.productcatalog.infrastructure.adaptar.repository;

import org.example.domain.productcatalog.infrastructure.adaptar.repository.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
}
