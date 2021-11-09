package org.example.domain.productcatalog.core.model.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.domain.productcatalog.core.model.ProductStatus;

@AllArgsConstructor
@Getter
public class UpdateProductStatusCommand {
    private final String productName;
    private final ProductStatus productStatus;
}
