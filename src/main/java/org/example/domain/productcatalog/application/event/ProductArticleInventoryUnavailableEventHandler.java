package org.example.domain.productcatalog.application.event;

import lombok.RequiredArgsConstructor;
import org.example.domain.article.application.event.ProductArticleInventoryAvailableEvent;
import org.example.domain.article.application.event.ProductArticleInventoryUnavailableEvent;
import org.example.domain.productcatalog.core.model.ProductStatus;
import org.example.domain.productcatalog.core.model.command.UpdateProductStatusCommand;
import org.example.domain.productcatalog.core.ports.incoming.UpdateProductStatus;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

//@Component
//@RequiredArgsConstructor
public class ProductArticleInventoryUnavailableEventHandler {


//    private final UpdateProductStatus updateProductStatus;
//
//    @EventListener
//    public void handle(final ProductArticleInventoryUnavailableEvent articleInventoryUnavailableEvent) {
//
//        updateProductStatus
//                .handle(new UpdateProductStatusCommand(articleInventoryUnavailableEvent.getProductName(), ProductStatus.AVAILABLE_BUT_ARTICLE_MISSING));
//
//    }
}