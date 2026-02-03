package com.ecommerce.user.domain;

@Entity
@Table(name="users")
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
