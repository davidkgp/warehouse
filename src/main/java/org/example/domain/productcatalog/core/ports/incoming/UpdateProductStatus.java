package org.example.domain.productcatalog.core.ports.incoming;

import org.example.domain.productcatalog.core.model.command.UpdateProductStatusCommand;

public interface UpdateProductStatus {
    void handle(UpdateProductStatusCommand updateProductStatusCommand);
}
