package org.example.domain.productcatalog.application.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArticleInventoryChangeEventHandler {


    @EventListener
    public void handle() {
;
    }
}