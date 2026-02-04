package com.ecommerce.auth.service;

import com.ecommerce.auth.client.UserClient;
import com.ecommerce.auth.dto.LoginRequest;
import com.ecommerce.auth.dto.LoginResponse;
import com.ecommerce.auth.dto.UserDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserClient userClient;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserClient userClient, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userClient = userClient;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public LoginResponse login(LoginRequest request) {
        UserDTO user = userClient.getUserByUsername(request.getUsername());

        if (user != null && passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            String token = jwtUtil.generateToken(user.getUsername(), user.getRole());
            return new LoginResponse(token);
        }

        throw new RuntimeException("Credenciais inválidas");
    }
}
