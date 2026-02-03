package com.ecommerce.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    private long id;
    private String username;
    private String email;
    private String password;

    public UserResponseDTO() {}

    public UserResponseDTO(long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public UserResponseDTO(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }


}
