package org.example.domain.productcatalog.application.rest.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Getter
public class ProductLine {
    @JsonProperty("name")
    private final String productName;
    @JsonProperty("contain_articles")
    private final List<ContainingArticles> containingArticlesList;
}
