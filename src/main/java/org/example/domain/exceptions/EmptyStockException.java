package org.example.domain.exceptions;

public class EmptyStockException extends RuntimeException {
    public EmptyStockException(String message) {
        super(message);
    }
}

