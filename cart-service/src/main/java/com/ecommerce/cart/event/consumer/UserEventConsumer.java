package com.ecommerce.cart.event.consumer;

import com.ecommerce.cart.event.model.UserValidatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventConsumer {

    @KafkaListener(topics = "user-events")
    public void consume(UserValidatedEvent event) {
        // Validar usuário
    }
}

