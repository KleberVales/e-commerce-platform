package com.ecommerce.cart.event.model;

import java.util.UUID;

public record UserValidatedEvent(
        UUID userId,
        boolean valid
) {}

