package com.ecommerce.cart.config;

public final class KafkaTopicsConfig {

    private KafkaTopicsConfig() {}

    public static final String PRODUCT_EVENTS = "product-events";
    public static final String USER_EVENTS = "user-events";
    public static final String ORDER_EVENTS = "order-events";
    public static final String CART_EVENTS = "cart-events";
    public static final String CHECKOUT_EVENTS = "checkout-events";
}

