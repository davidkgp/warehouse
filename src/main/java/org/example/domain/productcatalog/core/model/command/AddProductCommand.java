package org.example.domain.productcatalog.core.model.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.domain.productcatalog.application.rest.input.ProductLine;
import org.javatuples.Pair;

import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Getter
public class AddProductCommand {
    private final Set<Pair<ProductLine, Integer>> products;
}
