package com.ecommerce.user.service;

import com.ecommerce.user.domain.Role;
import com.ecommerce.user.domain.User;
import com.ecommerce.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    // ================== User Save ================================

    public User create(String username, String password, String email, Role role) {

        User user = new User();

        user.setUsername(username);
        user.setEmail(email);
        user.setPasswordHash(password);
        user.setRole(role);


        return repository.save(user);
    }

    // ================= Read operation ==============================
    public List<User> findAll(){
        return repository.findAll();
    }

    //=====================================================================================
    //                       searching for a specific user
    //=====================================================================================

    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }


    public User findByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User findByEmail(String email) {
        return repository.findByUsername(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
