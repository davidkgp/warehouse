package org.example.domain.productcatalog.core.ports.outgoing;

import org.example.domain.productcatalog.core.model.event.ProductSoldEvent;

public interface ProductSaleEventPublisher {
    void publish(ProductSoldEvent productSoldEvent);
}
