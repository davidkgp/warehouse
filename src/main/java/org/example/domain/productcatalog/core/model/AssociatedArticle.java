package org.example.domain.productcatalog.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AssociatedArticle {
    private final String id;
    private final int count;
}
