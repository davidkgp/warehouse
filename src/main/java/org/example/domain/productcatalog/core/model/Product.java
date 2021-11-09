package org.example.domain.productcatalog.core.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.exceptions.EmptyStockException;
import org.example.domain.exceptions.IllegalStockException;
import org.example.domain.exceptions.NotAvailableForSaleException;
import org.example.domain.exceptions.NotEnoughStockException;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public final class Product {

    private static Product INSTANCE;

    private final String productName;
    private final Set<AssociatedArticle> associatedArticles;
    private int stockQuantity = 0;
    private ProductStatus productStatus;

    private Product(final String productName, final Set<AssociatedArticle> associatedArticles, final int stockQuantity, final ProductStatus productStatus) {
        this.productName = productName;
        this.associatedArticles = associatedArticles;
        this.stockQuantity = stockQuantity;
        this.productStatus = productStatus;
    }

    public static Product initializeWithStock(final String productName, final Set<AssociatedArticle> associatedArticles, final int stockQuantity) {
        INSTANCE = new Product(productName, associatedArticles, stockQuantity, ProductStatus.UPLOADED_CHECKING_ARTICLE_STOCK);
        return INSTANCE;
    }

    public Product sellStock(final int quantity) {
        if (this.stockQuantity == 0)
            throw new EmptyStockException("Selling to is not  possible as empty stock");
        if (quantity > this.stockQuantity)
            throw new NotEnoughStockException("Selling to is not possible as less stock");
        if (!this.productStatus.equals(ProductStatus.AVAILABLE_FOR_SALE))
            throw new NotAvailableForSaleException("Selling to is not possible as product not available");

        this.stockQuantity = this.stockQuantity - quantity;
        return this;
    }

    public Product updateStatusIfSoldOut() {
        if (this.stockQuantity == 0) this.productStatus = ProductStatus.SOLD_OUT;
        return this;
    }

    public Product updateStatus(final ProductStatus productStatus) {
        this.productStatus = productStatus;
        return this;
    }

    public Product addStock(final int quantity) {
        if (quantity < 0) throw new IllegalStockException("Negetive stock of product not allowed");
        this.stockQuantity = this.stockQuantity + quantity;
        return this;
    }


}
