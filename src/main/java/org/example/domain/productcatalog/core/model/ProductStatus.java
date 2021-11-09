package org.example.domain.productcatalog.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProductStatus {
    UPLOADED_CHECKING_ARTICLE_STOCK("UPLOADED_CHECKING_ARTICLE_STOCK"),
    AVAILABLE_FOR_SALE("AVAILABLE_FOR_SALE"),
    AVAILABLE_BUT_ARTICLE_MISSING("AVAILABLE_BUT_ARTICLE_MISSING"),
    SOLD_OUT("SOLD_OUT");

    private final String value;
}
