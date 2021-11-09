package org.example.domain.productcatalog.application.rest.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Getter
public class ContainingArticles {


    @JsonProperty("art_id")
    private final String id;

    @JsonProperty("amount_of")
    private final int quantity;
}
