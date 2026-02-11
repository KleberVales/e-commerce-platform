package com.ecommerce.orderservice.client;

import com.ecommerce.orderservice.domain.model.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CartClient {

    private final WebClient webClient;

    public List<OrderItem> getCartItems(Long userId) {
        return webClient.get()
                .uri("http://localhost:8081/carts/{userId}", userId)
                .retrieve()
                .bodyToFlux(OrderItem.class)
                .collectList()
                .block();
    }
}
