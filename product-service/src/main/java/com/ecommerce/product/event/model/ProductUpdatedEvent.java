package com.ecommerce.product.event.model;

import com.ecommerce.product.entity.Product;
import java.math.BigDecimal;

public record ProductUpdatedEvent(
        String productId,
        String name,
        BigDecimal price,
        boolean active
) {
    public ProductUpdatedEvent(Product product) {
        this(product.getId(), product.getName(), product.getPrice(), product.isActive());
    }
}

