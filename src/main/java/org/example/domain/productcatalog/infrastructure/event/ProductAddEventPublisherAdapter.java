package org.example.domain.productcatalog.infrastructure.event;

import lombok.RequiredArgsConstructor;
import org.example.domain.productcatalog.core.model.event.ProductAddEvent;
import org.example.domain.productcatalog.core.ports.outgoing.ProductAddEventPublisher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductAddEventPublisherAdapter implements ProductAddEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void publish(final ProductAddEvent productAddEvent) {
        eventPublisher.publishEvent(productAddEvent);
    }
}
