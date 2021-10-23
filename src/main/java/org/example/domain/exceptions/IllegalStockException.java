package org.example.domain.exceptions;

public class IllegalStockException extends RuntimeException {
    public IllegalStockException(String message) {
        super(message);
    }
}

