package org.example.domain;


import org.example.domain.exceptions.IllegalStockException;
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

        assertEquals(7, article.addStock(5).getStock());
        assertEquals("3", updatedArticle.getId());
        assertEquals("name", updatedArticle.getName());

    }

}