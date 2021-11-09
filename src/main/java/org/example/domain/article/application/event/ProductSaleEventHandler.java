package org.example.domain.article.application.event;

import lombok.RequiredArgsConstructor;
import org.example.domain.productcatalog.core.model.ProductStatus;
import org.example.domain.productcatalog.core.model.command.UpdateProductStatusCommand;
import org.example.domain.productcatalog.core.model.event.ProductSoldEvent;
import org.example.domain.productcatalog.core.ports.incoming.UpdateProductStatus;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductSaleEventHandler {


    private final UpdateProductStatus updateProductStatus;

    @EventListener
    public void handle(final ProductSoldEvent productSellEvent) {

    }
}