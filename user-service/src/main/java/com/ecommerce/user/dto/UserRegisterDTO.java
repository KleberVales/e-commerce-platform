package com.ecommerce.user.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDTO {


    private String username;

    private String passwordHash;

    private String role; // ADMIN ou USER



}
