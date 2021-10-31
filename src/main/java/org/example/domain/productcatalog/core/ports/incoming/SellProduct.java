package org.example.domain.productcatalog.core.ports.incoming;

import org.example.domain.productcatalog.core.model.command.SellCommand;
import org.example.domain.productcatalog.core.model.output.SellOutput;

import java.util.Optional;

public interface SellProduct {

    Optional<SellOutput> handle(SellCommand sellCommand);
}
