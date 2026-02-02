package com.ecommerce.product.mapper;

import com.ecommerce.product.domain.Product;
import com.ecommerce.product.dto.ProductRequestDTO;
import com.ecommerce.product.dto.ProductResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProductMapper {

    private ProductMapper() {
        // Evita instanciação
    }

    // DTO → Entity
    public static Product toEntity(ProductRequestDTO dto) {
        return new Product(
                UUID.randomUUID(),
                dto.getName(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getActive() != null ? dto.getActive() : true,
                LocalDateTime.now()
        );
    }

    // Entity → DTO
    public static ProductResponseDTO toResponse(Product product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .active(product.isActive())
                .createdAt(product.getCreatedAt())
                .build();
    }
}
