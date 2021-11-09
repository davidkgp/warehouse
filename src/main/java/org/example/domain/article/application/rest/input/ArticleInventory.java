package org.example.domain.article.application.rest.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
@Getter
public class ArticleInventory {

    @JsonProperty("inventory")
    private final ArticleLine[] articleLines;

}

