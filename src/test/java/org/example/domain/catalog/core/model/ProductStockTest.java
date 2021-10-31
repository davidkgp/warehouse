package org.example.domain.catalog.core.model;

import org.example.domain.exceptions.EmptyStockException;
import org.example.domain.exceptions.IllegalStockException;
import org.example.domain.exceptions.NotEnoughStockException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductStockTest {

    @Test
    @DisplayName("Test add stock when the stock is empty,should increase stock")
    public void testAddStockWhenStockisEmptyforProduct() {

        ProductStock productStock = new ProductStock("name", 0);

        ProductStock updatedStock = productStock.addStock(5);
        assertEquals(5, updatedStock.getStockQuantity());
        assertEquals("name", updatedStock.getProductName());

    }

    @Test
    @DisplayName("Test add negative value to stock, should throw exception")
    public void testAddNegativeStock() {

        ProductStock productStock = new ProductStock("name", 0);

        assertThrows(IllegalStockException.class, () -> {
            productStock.addStock(-5);
        });


    }

    @Test
    @DisplayName("Test add positive value to stock,should increase stock")
    public void testAddPositiveStock() {

        ProductStock productStock = new ProductStock("name", 2);

        ProductStock updatedProductStock = productStock.addStock(5);

        assertEquals(7, updatedProductStock.getStockQuantity());
        assertEquals("name", updatedProductStock.getProductName());

    }

    @Test
    @DisplayName("Test reduce stock when stock is non empty, should reduce stock")
    public void testReduceStockWhenStockisNonEmpty() {

        ProductStock productStock = new ProductStock("name", 5);

        ProductStock updatedProductStock = productStock.sellStock(3);

        assertEquals(2, updatedProductStock.getStockQuantity());
        assertEquals("name", updatedProductStock.getProductName());

    }

    @Test
    @DisplayName("Test reduce stock when stock is empty, should throw exception")
    public void testReduceStockWhenStockisEmpty() {

        ProductStock productStock = new ProductStock("name", 0);

        assertThrows(EmptyStockException.class, () -> {
            productStock.sellStock(5);
        });


    }

    @Test
    @DisplayName("Test reduce stock when not enough stock, should throw exception")
    public void testReduceStockWhenStockisLess() {

        ProductStock productStock = new ProductStock("name", 7);

        assertThrows(NotEnoughStockException.class, () -> {
            productStock.sellStock(8);
        });


    }

}