package com.crud.api_crud_java_spring.domain.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequest(
        String id,
        @NotBlank
        String name,
        @NotNull
        Integer price_in_cents) {
}
