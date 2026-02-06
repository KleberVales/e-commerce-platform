package com.ecommerce.user.service;

import com.ecommerce.user.dto.UserRegisterDTO;
import com.ecommerce.user.dto.UserRequest;
import com.ecommerce.user.dto.UserResponse;
import com.ecommerce.user.entity.User;
import com.ecommerce.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository,
                       PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    // Registrando usuários
    public User register(UserRegisterDTO userRegisterDTO) {

        User user = new User();

        user.setUsername(userRegisterDTO.getUsername());
        user.setPasswordHash(passwordEncoder.encode(userRegisterDTO.getPasswordHash()));
        user.setRole(userRegisterDTO.getRole());


        return repository.save(user);

    }

    public UserResponse create(UserRequest request) {

        if (repository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("Username já existe");
        }

        User user = new User(
                request.getUsername(),
                passwordEncoder.encode(request.getPassword()),
                "USER"
        );

        User saved = repository.save(user);

        return new UserResponse(
                saved.getId(),
                saved.getUsername(),
                saved.getRole(),
                saved.isEnabled()
        );
    }

    public User findByUsernameInternal(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}

