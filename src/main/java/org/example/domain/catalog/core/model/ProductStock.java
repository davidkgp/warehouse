package org.example.domain.catalog.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.domain.exceptions.EmptyStockException;
import org.example.domain.exceptions.IllegalStockException;
import org.example.domain.exceptions.NotEnoughStockException;

@AllArgsConstructor
@Getter
public class ProductStock {

    private final String productName;
    private int stockQuantity;

    public ProductStock sellStock(final int quantity) {
        if(this.stockQuantity==0) throw new EmptyStockException("Selling to is not  possible as empty stock");
        if(quantity>this.stockQuantity) throw new NotEnoughStockException("Selling to is not possible as less stock");
        this.stockQuantity = this.stockQuantity - quantity;
        return this;
    }

    public ProductStock addStock(final int quantity) {
        if(quantity<0) throw new IllegalStockException("Negetive stock of product not allowed");
        this.stockQuantity = this.stockQuantity + quantity;
        return this;
    }

}
