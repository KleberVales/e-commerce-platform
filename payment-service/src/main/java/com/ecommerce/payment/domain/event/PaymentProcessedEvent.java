package com.ecommerce.payment.domain.event;

import com.ecommerce.payment.domain.enums.PaymentStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentProcessedEvent {

    private Long orderId;
    private PaymentStatus status;
}

