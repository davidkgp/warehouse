package org.example.domain.article.core.model;


import org.example.domain.exceptions.EmptyStockException;
import org.example.domain.exceptions.IllegalStockException;
import org.example.domain.exceptions.NotEnoughStockException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArticleTest {

    @Test
    @DisplayName("Test add stock when the stock is empty,should increase stock")
    public void testAddStockWhenStockisEmptyforArticle() {

        Article article = new Article("1","name", 0);

        Article updatedArticle = article.addStock(5);
        assertEquals(5, updatedArticle.getStock());
        assertEquals("1", updatedArticle.getId());
        assertEquals("name", updatedArticle.getName());

    }

    @Test
    @DisplayName("Test add negative value to stock, should throw exception")
    public void testAddNegativeStock() {

        Article article = new Article("2","name", 0);

        assertThrows(IllegalStockException.class, () -> {
            article.addStock(-5);
        });


    }

    @Test
    @DisplayName("Test add positive value to stock,should increase stock")
    public void testAddPositiveStock() {

        Article article = new Article("3","name", 2);

        Article updatedArticle = article.addStock(5);

        assertEquals(7, updatedArticle.getStock());
        assertEquals("3", updatedArticle.getId());
        assertEquals("name", updatedArticle.getName());

    }

    @Test
    @DisplayName("Test reduce stock when stock is non empty, should reduce stock")
    public void testReduceStockWhenStockisNonEmpty() {

        Article article = new Article("3","name", 5);

        Article updatedArticle = article.reduceStock(3);

        assertEquals(2, updatedArticle.getStock());
        assertEquals("3", updatedArticle.getId());
        assertEquals("name", updatedArticle.getName());

    }

    @Test
    @DisplayName("Test reduce stock when stock is empty, should throw exception")
    public void testReduceStockWhenStockisEmpty() {

        Article article = new Article("3","name", 0);

        assertThrows(EmptyStockException.class, () -> {
            article.reduceStock(5);
        });


    }

    @Test
    @DisplayName("Test reduce stock when not enough stock, should throw exception")
    public void testReduceStockWhenStockisLess() {

        Article article = new Article("3","name", 7);

        assertThrows(NotEnoughStockException.class, () -> {
            article.reduceStock(8);
        });


    }

}