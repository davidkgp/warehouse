package org.example.domain.productcatalog.core.ports.incoming;

import org.example.domain.productcatalog.core.model.command.AddProductCommand;
import org.example.domain.productcatalog.core.model.output.AddProductsOutput;

public interface AddNewProducts {
    AddProductsOutput handle(AddProductCommand products);
}
