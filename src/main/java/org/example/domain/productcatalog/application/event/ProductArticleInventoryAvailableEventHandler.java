package org.example.domain.productcatalog.application.event;

import lombok.RequiredArgsConstructor;
import org.example.domain.article.core.model.event.ProductArticleInventoryAvailableEvent;
import org.example.domain.productcatalog.core.model.ProductStatus;
import org.example.domain.productcatalog.core.model.command.UpdateProductStatusCommand;
import org.example.domain.productcatalog.core.ports.incoming.UpdateProductStatus;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductArticleInventoryAvailableEventHandler {

    private final UpdateProductStatus updateProductStatus;

    @EventListener
    public void handle(final ProductArticleInventoryAvailableEvent articleInventoryAvailableEvent) {

        updateProductStatus
                .handle(new UpdateProductStatusCommand(articleInventoryAvailableEvent.getProductName(), ProductStatus.AVAILABLE_FOR_SALE));

    }
}