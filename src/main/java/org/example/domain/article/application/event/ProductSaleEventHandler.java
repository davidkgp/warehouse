package org.example.domain.article.application.event;

import lombok.RequiredArgsConstructor;
import org.example.domain.article.core.model.command.ReduceArticleCommand;
import org.example.domain.article.core.ports.incoming.ReduceArticleStock;
import org.example.domain.productcatalog.core.model.event.ProductSoldEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductSaleEventHandler {


    private final ReduceArticleStock reduceArticleStock;

    @EventListener
    public void handle(final ProductSoldEvent productSellEvent) {

        productSellEvent
                .getArticlesToBeShipped()
                .forEach(obj -> reduceArticleStock
                        .handle(new ReduceArticleCommand(obj.getArticleId(), obj.getRequiredQuantity())));


    }
}