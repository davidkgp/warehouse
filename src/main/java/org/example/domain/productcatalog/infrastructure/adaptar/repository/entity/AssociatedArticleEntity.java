package org.example.domain.productcatalog.infrastructure.adaptar.repository.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.domain.productcatalog.core.model.AssociatedArticle;
import org.example.domain.productcatalog.core.model.Product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@RequiredArgsConstructor
@Getter
@Entity(name="associated_article")
@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
public class AssociatedArticleEntity {
    @Id
    private final String id;
    private final int count;

    public AssociatedArticle toAssociatedArticleEntityDomain(){
        return new AssociatedArticle(this.id.substring(0,this.id.indexOf("_")), this.count);
    }

    public static AssociatedArticleEntity fromAssociatedArticleEntityDomain(final AssociatedArticle associatedArticle, final String productName){
        return new AssociatedArticleEntity(associatedArticle.getId()+"_"+productName, associatedArticle.getCount());
    }
}
