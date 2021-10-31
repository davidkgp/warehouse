package org.example.domain.productcatalog.core.model.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SellCommand {

    private final String sellProductName;

    private final int sellQuantity;
}
