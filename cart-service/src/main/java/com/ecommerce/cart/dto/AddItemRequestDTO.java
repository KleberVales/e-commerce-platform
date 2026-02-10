package com.ecommerce.cart.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AddItemRequestDTO {
    private UUID productId;
    private Integer quantity;

    // getters e setters
}

