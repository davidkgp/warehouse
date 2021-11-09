package org.example.domain.article.core.ports.outgoing;

import org.example.domain.article.core.model.event.ProductArticleInventoryUnavailableEvent;

public interface ProductArticleUnavailableEventPublisher {
    void publish(ProductArticleInventoryUnavailableEvent productArticleInventoryUnavailableEvent);
}
