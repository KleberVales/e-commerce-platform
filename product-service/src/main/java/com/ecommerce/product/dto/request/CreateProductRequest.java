package com.ecommerce.product.dto.request;

import java.math.BigDecimal;

public record CreateProductRequest(
        String name,
        String description,
        BigDecimal price
) {}

