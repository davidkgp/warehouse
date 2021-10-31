package org.example.domain.catalog.application;

import lombok.RequiredArgsConstructor;
import org.example.domain.catalog.application.request.SellProductRequest;
import org.example.domain.catalog.application.request.SellProductResponse;
import org.example.domain.catalog.core.model.command.SellCommand;
import org.example.domain.catalog.core.model.output.SellOutput;
import org.example.domain.catalog.core.ports.incoming.SellProduct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final SellProduct catalog;


    @PostMapping("/sell")
    public ResponseEntity<SellProductResponse> sellProduct(@RequestBody final SellProductRequest sellProductRequest) {

        final SellCommand sellCommand = new SellCommand(sellProductRequest.getProductName(), sellProductRequest.getQuantity());

        final Optional<SellOutput> sellOutput = catalog.handle(sellCommand);

        return sellOutput
                .map(output -> ResponseEntity.accepted()
                        .body(new SellProductResponse(output.getSellStatus()))
                ).orElseGet(() -> ResponseEntity.notFound().build());


    }
}
