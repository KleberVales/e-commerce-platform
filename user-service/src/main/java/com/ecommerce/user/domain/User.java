package com.ecommerce.user.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String passwordHash;
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;




}
