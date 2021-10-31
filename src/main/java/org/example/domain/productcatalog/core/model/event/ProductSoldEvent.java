package org.example.domain.productcatalog.core.model.event;

import lombok.Getter;
import org.example.domain.kernel.event.DomainEvent;
import org.example.domain.productcatalog.core.model.AssociatedArticle;

import java.util.Set;
import java.util.stream.Collectors;


@Getter
public class ProductSoldEvent extends DomainEvent {

    private final String productName;
    private final int quantitySold;
    private final Set<ArticleAssociated> articlesToBeShipped;

    private ProductSoldEvent(final String productName, final int quantitySold, final Set<ArticleAssociated> articlesToBeShipped) {
        super();
        this.productName = productName;
        this.quantitySold = quantitySold;
        this.articlesToBeShipped = articlesToBeShipped;
    }

    public static ProductSoldEvent fromSaleDetails(final String productName, final int quantitySold, Set<AssociatedArticle> associatedArticles) {

        return new ProductSoldEvent(productName, quantitySold, associatedArticles
                .stream()
                .map(associatedArticle -> new ArticleAssociated(associatedArticle.getCount() * quantitySold, associatedArticle.getId()))
                .collect(Collectors.toSet()));
    }
}
