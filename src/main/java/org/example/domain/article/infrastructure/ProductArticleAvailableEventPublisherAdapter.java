package org.example.domain.article.infrastructure;

import lombok.RequiredArgsConstructor;
import org.example.domain.article.core.model.event.ProductArticleInventoryAvailableEvent;
import org.example.domain.article.core.ports.outgoing.ProductArticleAvailableEventPublisher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductArticleAvailableEventPublisherAdapter implements ProductArticleAvailableEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void publish(ProductArticleInventoryAvailableEvent productArticleInventoryAvailableEvent) {
        eventPublisher.publishEvent(productArticleInventoryAvailableEvent);
    }
}
