package org.example.domain.article.config;

import org.example.domain.article.core.ports.ArticleFacade;
import org.example.domain.article.core.ports.incoming.AddArticles;
import org.example.domain.article.core.ports.incoming.CheckArticleStock;
import org.example.domain.article.core.ports.incoming.ReduceArticleStock;
import org.example.domain.article.core.ports.outgoing.ArticleDatabase;
import org.example.domain.article.core.ports.outgoing.ProductArticleAvailableEventPublisher;
import org.example.domain.article.core.ports.outgoing.ProductArticleUnavailableEventPublisher;
import org.example.domain.article.infrastructure.ArticleDatabaseAdaptar;
import org.example.domain.article.infrastructure.ArticleRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArticleConfig {

    @Bean
    public CheckArticleStock checkArticleStock(final ArticleDatabase articleDatabase, final ProductArticleAvailableEventPublisher productArticleAvailableEventPublisher, final ProductArticleUnavailableEventPublisher productArticleUnavailableEventPublisher) {
        return new ArticleFacade(articleDatabase,productArticleAvailableEventPublisher,productArticleUnavailableEventPublisher);
    }


    @Bean
    @Qualifier("addArticles")
    public AddArticles getAddArticles(final ArticleDatabase articleDatabase,final ProductArticleAvailableEventPublisher productArticleAvailableEventPublisher,final ProductArticleUnavailableEventPublisher productArticleUnavailableEventPublisher) {
        return new ArticleFacade(articleDatabase,productArticleAvailableEventPublisher,productArticleUnavailableEventPublisher);
    }

    @Bean
    @Qualifier("reduceStock")
    public ReduceArticleStock getReduceArticleStock(final ArticleDatabase articleDatabase,final ProductArticleAvailableEventPublisher productArticleAvailableEventPublisher,final ProductArticleUnavailableEventPublisher productArticleUnavailableEventPublisher) {
        return new ArticleFacade(articleDatabase,productArticleAvailableEventPublisher,productArticleUnavailableEventPublisher);
    }

    @Bean
    public ArticleDatabase articleDatabase(final ArticleRepository articleRepository) {
        return new ArticleDatabaseAdaptar(articleRepository);
    }

}
