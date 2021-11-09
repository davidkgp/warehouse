package org.example.domain.productcatalog.core.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
public class AssociatedArticle {
    @Id
    private final String id;
    private final int count;
}
