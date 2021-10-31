package org.example.domain.productcatalog.core.model.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ProductLine {
    private final String productName;
    private final List<ContainingArticles> containingArticlesList;
}
