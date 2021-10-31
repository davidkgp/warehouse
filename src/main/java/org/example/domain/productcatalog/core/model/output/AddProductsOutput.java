package org.example.domain.productcatalog.core.model.output;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddProductsOutput {

    private final int added;
    private final int failed;
}
