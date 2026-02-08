package com.ecommerce.product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    private String id;

    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;

    @PrePersist
    public void prePersist() {
        this.id = UUID.randomUUID().toString();
        this.active = true;
    }

    // getters e setters

}
