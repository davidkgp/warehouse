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
public class ArticleLine {

    @JsonProperty("art_id")
    private final String id;
    private final String name;
    private final int stock;

}
