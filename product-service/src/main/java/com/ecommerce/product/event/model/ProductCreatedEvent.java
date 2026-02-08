package com.ecommerce.product.event.model;

import com.ecommerce.product.entity.Product;
import java.math.BigDecimal;

public record ProductCreatedEvent(
        String productId,
        String name,
        BigDecimal price,
        boolean active
) {
    public ProductCreatedEvent(Product product) {
        this(product.getId(), product.getName(), product.getPrice(), product.isActive());
    }
}

