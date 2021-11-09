package org.example.domain.article.core.ports;

import lombok.AllArgsConstructor;
import org.example.domain.article.core.model.Article;
import org.example.domain.article.core.model.command.ReduceArticleCommand;
import org.example.domain.article.core.ports.incoming.AddArticles;
import org.example.domain.article.core.ports.incoming.ReduceArticleStock;
import org.example.domain.article.core.ports.outgoing.ArticleDatabase;
import org.example.domain.exceptions.ArticleNotFoundException;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ArticleFacade implements AddArticles, ReduceArticleStock {

    private ArticleDatabase articleDatabase;

    @Override
    public int handle(List<Article> articles) {

        articles.stream()
                .map(articleIncrease -> {
                    Optional<Article> articleDBResult = articleDatabase.get(articleIncrease.getId());
                    return articleDBResult
                            .map(article -> article.addStock(articleIncrease.getStock()))
                            .orElse(articleIncrease);

                })
                .forEach(article -> articleDatabase.save(article));


        return articles.stream().map(Article::getStock).reduce(0, Integer::sum);
    }

    @Override
    public void handle(final ReduceArticleCommand reduceArticleCommand) {

        Optional<Article> articleDBResult = articleDatabase.get(reduceArticleCommand.getArticleId());

        articleDBResult
                .map(article -> article.reduceStock(reduceArticleCommand.getReduction()))
                .map(article -> articleDatabase.save(article))
                .orElseThrow(() -> new ArticleNotFoundException(String.format("Article %s not found", reduceArticleCommand.getArticleId())));


    }
}
