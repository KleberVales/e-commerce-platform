package com.ecommerce.cart.event.producer;

import com.ecommerce.cart.config.KafkaTopicsConfig;
import com.ecommerce.cart.event.model.CheckoutRequestedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CheckoutEventProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public CheckoutEventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(CheckoutRequestedEvent event) {
        kafkaTemplate.send(KafkaTopicsConfig.CHECKOUT_EVENTS, event);
    }
}

