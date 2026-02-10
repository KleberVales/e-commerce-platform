package com.ecommerce.cart.event.consumer;

import com.ecommerce.cart.event.model.ProductSnapshotEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ProductEventConsumer {

    @KafkaListener(topics = "product-events")
    public void consume(ProductSnapshotEvent event) {
        // Atualizar snapshot do produto
    }
}

