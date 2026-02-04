package com.ecommerce.user.repository;

import com.ecommerce.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsernameOrEmail(String username, String email);
    Optional<User> findByUsername(String username);



}
