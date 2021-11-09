package org.example.domain.article.core.ports.outgoing;

import org.example.domain.article.core.model.Article;

import java.util.Optional;

public interface ArticleDatabase {
    Optional<Article> get(String articleId);

    Article save(Article article);
}
