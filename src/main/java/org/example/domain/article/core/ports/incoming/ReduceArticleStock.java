package org.example.domain.article.core.ports.incoming;

public interface ReduceArticleStock {
    void handle(String articleId, int reduction);
}
