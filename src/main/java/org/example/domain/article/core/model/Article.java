package org.example.domain.article.core.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.exceptions.EmptyStockException;
import org.example.domain.exceptions.IllegalStockException;
import org.example.domain.exceptions.NotEnoughStockException;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
public final class Article {
    @Id
    private final String id;
    private final String name;
    private final int stock;

    public Article addStock(final int newItems) {
        if (newItems < 0) throw new IllegalStockException("New items' count cannot be negative");
        return new Article(this.id, this.name, this.stock + newItems);
    }

    public Article reduceStock(final int itemsDeducted) {
        if (this.stock == 0) throw new EmptyStockException("Stock already empty,cannot reduce more");
        if (this.stock < itemsDeducted) throw new NotEnoughStockException("Not enough stock present");
        return new Article(this.id, this.name, this.stock - itemsDeducted);
    }
}
