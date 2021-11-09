package org.example.domain.article.config;

import org.example.domain.article.core.ports.ArticleFacade;
import org.example.domain.article.core.ports.incoming.AddArticles;
import org.example.domain.article.core.ports.incoming.ReduceArticleStock;
import org.example.domain.article.core.ports.outgoing.ArticleDatabase;
import org.example.domain.article.infrastructure.ArticleDatabaseAdaptar;
import org.example.domain.article.infrastructure.ArticleRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArticleConfig {

    @Bean
    @Qualifier("addArticles")
    public AddArticles getAddArticles(final ArticleDatabase articleDatabase) {
        return new ArticleFacade(articleDatabase);
    }

    @Bean
    @Qualifier("reduceStock")
    public ReduceArticleStock getReduceArticleStock(final ArticleDatabase articleDatabase) {
        return new ArticleFacade(articleDatabase);
    }

    @Bean
    public ArticleDatabase articleDatabase(final ArticleRepository articleRepository) {
        return new ArticleDatabaseAdaptar(articleRepository);
    }

}
