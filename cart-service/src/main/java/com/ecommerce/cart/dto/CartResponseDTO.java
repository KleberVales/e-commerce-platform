package com.ecommerce.cart.dto;

import java.util.List;
import java.util.UUID;

public record CartResponseDTO(
        UUID cartId,
        UUID userId,
        String status,
        List<CartItemDTO> items
) {}

