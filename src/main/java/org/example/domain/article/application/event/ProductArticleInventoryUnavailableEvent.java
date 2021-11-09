package org.example.domain.article.application.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductArticleInventoryUnavailableEvent {
    private String productName;
}

