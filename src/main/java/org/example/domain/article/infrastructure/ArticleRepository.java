package org.example.domain.article.infrastructure;

import org.example.domain.article.core.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, String> {
}
