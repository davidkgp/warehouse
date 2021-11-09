package org.example.domain.article.core.model.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductArticleInventoryAvailableEvent {

    private String productName;

}
