package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.domain.exceptions.IllegalStockException;

@Getter
@AllArgsConstructor
public class Article {
    private final String id;
    private final String name;
    private final int stock;

    public Article addStock(final int newItems) {
        if (newItems < 0) throw new IllegalStockException("New items cannot be negative");
        return new Article(this.id, this.name, this.stock + newItems);
    }

    public Article reduceStock(final int itemsDeducted) {
        return null;
    }
}
