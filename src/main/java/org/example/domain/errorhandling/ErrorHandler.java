package org.example.domain.errorhandling;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.exceptions.ArticleNotFoundException;
import org.example.domain.exceptions.EmptyStockException;
import org.example.domain.exceptions.IllegalStockException;
import org.example.domain.exceptions.NotAvailableForSaleException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.OffsetTime;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(ArticleNotFoundException.class)
    public ResponseEntity<ErrorResponse>
    handleArticleNotFoundException(final ArticleNotFoundException articleNotFoundException, final WebRequest request) {
        log.error(String.format("Exception happened %s", articleNotFoundException));
        return new ResponseEntity<>(new ErrorResponse(articleNotFoundException.getMessage(), OffsetTime.now()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyStockException.class)
    public ResponseEntity<ErrorResponse>
    handleEmptyStockException(final EmptyStockException emptyStockException, final WebRequest request) {
        log.error(String.format("Exception happened %s", emptyStockException));
        return new ResponseEntity<>(new ErrorResponse(emptyStockException.getMessage(), OffsetTime.now()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalStockException.class)
    public ResponseEntity<ErrorResponse>
    handleIllegalStockException(final IllegalStockException illegalStockException, final WebRequest request) {
        log.error(String.format("Exception happened %s", illegalStockException));
        return new ResponseEntity<>(new ErrorResponse(illegalStockException.getMessage(), OffsetTime.now()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotAvailableForSaleException.class)
    public ResponseEntity<ErrorResponse>
    handleNotAvailableForSaleException(final NotAvailableForSaleException notAvailableForSaleException, final WebRequest request) {
        log.error(String.format("Exception happened %s", notAvailableForSaleException));
        return new ResponseEntity<>(new ErrorResponse(notAvailableForSaleException.getMessage(), OffsetTime.now()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse>
    handlePlayerNotFoundException(final Exception unknownException, final WebRequest request) {
        log.error(String.format("Unknown Exception happened %s", unknownException));
        return new ResponseEntity<>(new ErrorResponse(unknownException.getMessage(), OffsetTime.now()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
