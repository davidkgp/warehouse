package org.example.domain.article.application.event;

import lombok.RequiredArgsConstructor;
import org.example.domain.article.core.ports.incoming.ReduceArticleStock;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArticleUpdateEventHandler {

    @Qualifier("reduceStock")
    private final ReduceArticleStock reduceArticleStock;

    @EventListener
    public void handle(final ArticleReduceEvent articleReduceEvent) {

        articleReduceEvent
                .getReductions()
                .forEach(data -> reduceArticleStock
                        .handle(data.getValue0(), data.getValue1()));

    }
}