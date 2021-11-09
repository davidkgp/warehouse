package org.example.domain.article.infrastructure;

import lombok.AllArgsConstructor;
import org.example.domain.article.core.model.Article;
import org.example.domain.article.core.ports.outgoing.ArticleDatabase;

import java.util.Optional;

@AllArgsConstructor
public class ArticleDatabaseAdaptar implements ArticleDatabase {

    private final ArticleRepository articleRepository;

    @Override
    public Optional<Article> get(final String articleId) {
        return articleRepository.findById(articleId);
    }

    @Override
    public Article save(final Article article) {
        return articleRepository.save(article);
    }
}
