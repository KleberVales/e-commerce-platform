package com.ecommerce.cart.event.model;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductSnapshotEvent(
        UUID productId,
        String name,
        BigDecimal price
) {}

