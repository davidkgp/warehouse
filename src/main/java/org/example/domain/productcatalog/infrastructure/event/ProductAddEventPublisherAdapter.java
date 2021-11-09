package org.example.domain.productcatalog.infrastructure.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.productcatalog.core.model.event.ProductAddEvent;
import org.example.domain.productcatalog.core.ports.outgoing.ProductAddEventPublisher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductAddEventPublisherAdapter implements ProductAddEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void publish(final ProductAddEvent productAddEvent) {
        log.info("Product add event triggered for "+productAddEvent.getProductName());
        eventPublisher.publishEvent(productAddEvent);
    }
}
