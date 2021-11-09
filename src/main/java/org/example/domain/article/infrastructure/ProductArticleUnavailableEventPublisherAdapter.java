package org.example.domain.article.infrastructure;

import lombok.RequiredArgsConstructor;
import org.example.domain.article.core.model.event.ProductArticleInventoryUnavailableEvent;
import org.example.domain.article.core.ports.outgoing.ProductArticleUnavailableEventPublisher;
import org.example.domain.productcatalog.core.model.event.ProductSoldEvent;
import org.example.domain.productcatalog.core.ports.outgoing.ProductSaleEventPublisher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductArticleUnavailableEventPublisherAdapter implements ProductArticleUnavailableEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void publish(ProductArticleInventoryUnavailableEvent productArticleInventoryUnavailableEvent) {
        eventPublisher.publishEvent(productArticleInventoryUnavailableEvent);
    }
}
