package com.ecommerce.cart.event.model;

import java.util.List;
import java.util.UUID;

public record CheckoutRequestedEvent(
        UUID cartId,
        UUID userId,
        List<UUID> productIds
) {}

