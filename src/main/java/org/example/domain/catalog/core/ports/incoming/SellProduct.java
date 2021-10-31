package org.example.domain.catalog.core.ports.incoming;

import org.example.domain.catalog.core.model.command.SellCommand;
import org.example.domain.catalog.core.model.output.SellOutput;

import java.util.Optional;

public interface SellProduct {
    Optional<SellOutput> handle(SellCommand sellCommand);
}
