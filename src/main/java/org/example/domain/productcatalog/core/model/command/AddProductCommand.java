package org.example.domain.productcatalog.core.model.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class AddProductCommand {
    //could have been a Set of Tuple
    private final Map<ProductLine, Integer> products;
}