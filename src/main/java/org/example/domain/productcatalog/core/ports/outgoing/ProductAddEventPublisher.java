package org.example.domain.productcatalog.core.ports.outgoing;

import org.example.domain.productcatalog.core.model.event.ProductAddEvent;

public interface ProductAddEventPublisher {
    void publish(ProductAddEvent productAddEvent);
}
