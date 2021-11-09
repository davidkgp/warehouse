package org.example.domain.article.core.ports;

import lombok.AllArgsConstructor;
import org.example.domain.article.core.model.Article;
import org.example.domain.article.core.model.command.CheckProductArticleStockCommand;
import org.example.domain.article.core.model.command.ReduceArticleCommand;
import org.example.domain.article.core.model.event.ProductArticleInventoryAvailableEvent;
import org.example.domain.article.core.model.event.ProductArticleInventoryUnavailableEvent;
import org.example.domain.article.core.ports.incoming.AddArticles;
import org.example.domain.article.core.ports.incoming.CheckArticleStock;
import org.example.domain.article.core.ports.incoming.ReduceArticleStock;
import org.example.domain.article.core.ports.outgoing.ArticleDatabase;
import org.example.domain.article.core.ports.outgoing.ProductArticleAvailableEventPublisher;
import org.example.domain.article.core.ports.outgoing.ProductArticleUnavailableEventPublisher;
import org.example.domain.exceptions.ArticleNotFoundException;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ArticleFacade implements AddArticles, ReduceArticleStock, CheckArticleStock {

    private final ArticleDatabase articleDatabase;
    private final ProductArticleAvailableEventPublisher productArticleAvailableEventPublisher;
    private final ProductArticleUnavailableEventPublisher productArticleUnavailableEventPublisher;

    @Override
    public int handle(List<Article> articles) {

        articles.stream()
                .map(articleIncrease -> {
                    Optional<Article> articleDBResult = articleDatabase.get(articleIncrease.getId());
                    return articleDBResult
                            .map(article -> article.addStock(articleIncrease.getStock()))
                            .orElse(articleIncrease);

                })
                .forEach(articleDatabase::save);


        return articles.stream().map(Article::getStock).reduce(0, Integer::sum);
    }

    @Override
    public void handle(final ReduceArticleCommand reduceArticleCommand) {

        Optional<Article> articleDBResult = articleDatabase.get(reduceArticleCommand.getArticleId());

        articleDBResult
                .map(article -> article.reduceStock(reduceArticleCommand.getReduction()))
                .map(articleDatabase::save)
                .orElseThrow(() -> new ArticleNotFoundException(String.format("Article %s not found", reduceArticleCommand.getArticleId())));


    }

    @Override
    public void handle(CheckProductArticleStockCommand checkArticleStockCommand) {

        boolean stockPresent = checkArticleStockCommand
                .getArticleStockList().stream()
                .allMatch(articleStock ->
                        articleDatabase
                                .get(articleStock.getId())
                                .map(articleDb -> articleDb.getStock() >= articleStock.getStockQuantity()).orElse(false));
        if (stockPresent) {
            productArticleAvailableEventPublisher.publish(new ProductArticleInventoryAvailableEvent(checkArticleStockCommand.getProductName()));
        } else {
            productArticleUnavailableEventPublisher.publish(new ProductArticleInventoryUnavailableEvent(checkArticleStockCommand.getProductName()));
        }

    }
}
