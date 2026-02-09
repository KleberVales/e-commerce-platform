package com.ecommerce.cart.util;

import org.apache.kafka.common.header.Headers;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;

public class KafkaHeadersUtil {

    public static <T> org.springframework.messaging.Message<T> withKey(T payload, String key) {
        return MessageBuilder.withPayload(payload)
                .setHeader(KafkaHeaders.KEY, key)
                .build();
    }
}

