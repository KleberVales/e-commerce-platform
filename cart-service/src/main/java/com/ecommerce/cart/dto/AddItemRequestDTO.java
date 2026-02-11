package com.ecommerce.cart.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class AddItemRequestDTO {

    private UUID productId;
    private Integer quantity;
    private BigDecimal price;


    // getters e setters
}

