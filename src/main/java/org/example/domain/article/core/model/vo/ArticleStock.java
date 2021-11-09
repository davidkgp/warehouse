package org.example.domain.article.core.model.vo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
public class ArticleStock {
    private final String id;
    private final int stockQuantity;
}
