package org.example.domain.productcatalog.core.model.event;

import lombok.Getter;
import org.example.kernel.event.DomainEvent;
import org.example.domain.productcatalog.core.model.AssociatedArticle;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
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

    public static ProductAddEvent fromProductAdd(final String productName, final int stockAdded, final Set<AssociatedArticle> associatedArticles) {
        return new ProductAddEvent(productName, stockAdded, associatedArticles
                .stream()
                .map(associatedArticle -> new ArticleAssociated(associatedArticle.getCount() * stockAdded, associatedArticle.getId()))
                .collect(Collectors.toSet()));
    }

}
