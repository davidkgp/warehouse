package org.example.domain.productcatalog.core.model.event;

import org.example.domain.kernel.event.DomainEvent;

import java.util.Set;

public class ProductAddEvent extends DomainEvent {

    private final String productName;
    private final int stockAdded;
    private final Set<ArticleAssociated> articlesToBeReserved;

    private ProductAddEvent(final String productName, final int stockAdded, final Set<ArticleAssociated> articlesToBeReserved) {
        super();
        this.productName = productName;
        this.stockAdded = stockAdded;
        this.articlesToBeReserved = articlesToBeReserved;
    }

}
