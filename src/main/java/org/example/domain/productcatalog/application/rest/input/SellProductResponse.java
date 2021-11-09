package org.example.domain.productcatalog.application.rest.input;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Validated
public class SellProductResponse {

    @NotNull(message = "sell status cannot be empty")
    private String sellStatus;
}
