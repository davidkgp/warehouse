package org.example.domain.productcatalog.core.model.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ArticleAssociated {

    private final int requiredQuantity;
    private final String articleId;
}
