package com.ecommerce.user.dto;

import com.ecommerce.user.domain.Role;
import lombok.Getter;

@Getter
public class UserRequestDTO {

    private String username;
    private String email;
    private String passwordHash;

    private Role role;


}