package com.ecommerce.cart.event.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventConsumer {

    @KafkaListener(topics = "order-events")
    public void consume(Object event) {
        // Processar retorno do order-service
    }
}
