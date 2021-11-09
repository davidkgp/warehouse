package org.example.domain.productcatalog.infrastructure.adaptar.repository.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.domain.productcatalog.core.model.Product;
import org.example.domain.productcatalog.core.model.ProductStatus;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@Entity(name = "product")
public final class ProductEntity {

    @Id
    private final String productName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_product")
    private final Set<AssociatedArticleEntity> associatedArticles;
    private final int stockQuantity;
    @Enumerated(EnumType.STRING)
    private final ProductStatus productStatus;

    public Product getProductDomain() {
        Product productDomain = Product.initializeWithStock(this.productName
                , this.associatedArticles.stream()
                        .map(AssociatedArticleEntity::toAssociatedArticleEntityDomain)
                        .collect(Collectors.toSet())
                , this.stockQuantity);
        return productDomain.updateStatus(productStatus);
    }

    public static ProductEntity fromProductDomain(final Product product) {

        return new ProductEntity(product.getProductName()
                , product.getAssociatedArticles()
                .stream().map(obj->AssociatedArticleEntity.fromAssociatedArticleEntityDomain(obj, product.getProductName()))
                .collect(Collectors.toSet()),
                product.getStockQuantity(),
                product.getProductStatus());
    }
}
