package com.ecommerce.payment.service;

import com.ecommerce.payment.domain.enums.PaymentStatus;
import com.ecommerce.payment.domain.event.OrderCreatedEvent;
import com.ecommerce.payment.domain.model.Payment;
import com.ecommerce.payment.messaging.producer.PaymentResultProducer;
import com.ecommerce.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentResultProducer paymentResultProducer;

    public void processPayment(OrderCreatedEvent event) {

        Payment payment = Payment.builder()
                .orderId(event.getOrderId())
                .userId(event.getUserId())
                .amount(event.getTotal())
                .status(PaymentStatus.SUCCESS) // simulate success
                .createdAt(LocalDateTime.now())
                .build();

        paymentRepository.save(payment);

        paymentResultProducer.publishPaymentResult(
                event.getOrderId(),
                PaymentStatus.SUCCESS
        );
    }
}

