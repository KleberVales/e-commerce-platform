package com.ecommerce.user.controller;

import com.ecommerce.user.domain.User;
import com.ecommerce.user.dto.UserRequestDTO;
import com.ecommerce.user.dto.UserResponseDTO;
import com.ecommerce.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserResponseDTO registerUser(@RequestBody UserRequestDTO userRequestDTO) {

        User user = userService.create(userRequestDTO.getUsername(),
                userRequestDTO.getEmail(), userRequestDTO.getPasswordHash(), userRequestDTO.getRole());

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setUsername(user.getUsername());
        userResponseDTO.setId(user.getId());


        return userResponseDTO;
    }

    //=============================== Operation read =========================================
    @GetMapping
    public List<UserResponseDTO> findAll() {
        return userService.findAll().stream()
                .map(user -> new UserResponseDTO(user.getId(), user.getUsername(), user.getEmail(),
                        user.getPasswordHash()))
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {

        User user = userService.findById(id);

        UserResponseDTO dto = new UserResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPasswordHash()
        );

        return ResponseEntity.ok(dto);
    }

}