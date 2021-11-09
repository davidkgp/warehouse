package org.example.domain.article.application.event;

import lombok.RequiredArgsConstructor;
import org.example.domain.article.core.model.command.CheckProductArticleStockCommand;
import org.example.domain.article.core.model.vo.ArticleStock;
import org.example.domain.article.core.ports.incoming.CheckArticleStock;
import org.example.domain.productcatalog.core.model.event.ProductAddEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductAddEventHandler {

    private final CheckArticleStock checkArticleStock;

    @EventListener
    public void handle(final ProductAddEvent productAddEvent) {

        checkArticleStock
                .handle(new CheckProductArticleStockCommand(productAddEvent.getProductName()
                        , productAddEvent.getArticlesToBeReserved().stream().map(obj -> new ArticleStock(obj.getArticleId(), obj.getRequiredQuantity())).collect(Collectors.toList())));

    }
}