package org.example.domain.article.core.ports.incoming;

import org.example.domain.article.core.model.Article;

import java.util.List;

public interface AddArticles {
    int handle(List<Article> articles);
}
