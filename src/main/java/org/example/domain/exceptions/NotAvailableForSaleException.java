package org.example.domain.exceptions;

public class NotAvailableForSaleException extends RuntimeException {
    public NotAvailableForSaleException(String message) {
        super(message);
    }
}
