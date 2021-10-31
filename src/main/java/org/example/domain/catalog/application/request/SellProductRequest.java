package org.example.domain.catalog.application.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Validated
@Getter
public class SellProductRequest {

    @NotNull(message = "product name cannot null")
    @NotEmpty(message = "product name cannot be empty")
    private String productName;

    @Min(value = 1, message = "quantity should not be less than 1")
    private int quantity;
}
