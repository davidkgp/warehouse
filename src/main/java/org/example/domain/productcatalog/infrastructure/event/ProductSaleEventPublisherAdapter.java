package org.example.domain.productcatalog.infrastructure.event;

import lombok.RequiredArgsConstructor;
import org.example.domain.productcatalog.core.model.event.ProductSoldEvent;
import org.example.domain.productcatalog.core.ports.outgoing.ProductSaleEventPublisher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductSaleEventPublisherAdapter implements ProductSaleEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void publish(final ProductSoldEvent productSoldEvent) {
        eventPublisher.publishEvent(productSoldEvent);
    }
}
