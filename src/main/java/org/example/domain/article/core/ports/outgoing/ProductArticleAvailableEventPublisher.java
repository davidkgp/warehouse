package org.example.domain.article.core.ports.outgoing;

import org.example.domain.article.core.model.event.ProductArticleInventoryAvailableEvent;

public interface ProductArticleAvailableEventPublisher {
    void publish(ProductArticleInventoryAvailableEvent productArticleInventoryAvailableEvent);
}
