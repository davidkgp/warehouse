package org.example.domain.catalog.core;

import org.example.domain.catalog.core.model.command.SellCommand;
import org.example.domain.catalog.core.model.output.SellOutput;
import org.example.domain.catalog.core.ports.incoming.SellProduct;

import java.util.Optional;

public class CatalogFacade implements SellProduct {
    @Override
    public Optional<SellOutput> handle(final SellCommand sellCommand) {



        return Optional.empty();
    }
}
