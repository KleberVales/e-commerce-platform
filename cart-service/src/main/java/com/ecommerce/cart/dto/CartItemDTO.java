package com.ecommerce.cart.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record CartItemDTO(
        UUID productId,
        String productName,
        BigDecimal price,
        int quantity
) {}

