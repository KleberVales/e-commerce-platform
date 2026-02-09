package com.ecommerce.cart.event.producer;

import com.ecommerce.cart.config.KafkaTopicsConfig;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CartEventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public CartEventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Object event) {
        kafkaTemplate.send(KafkaTopicsConfig.CART_EVENTS, event);
    }
}

