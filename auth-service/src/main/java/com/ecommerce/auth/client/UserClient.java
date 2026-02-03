package com.ecommerce.auth.client;

import com.ecommerce.auth.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-service", url = "http://localhost:8081/api/users")
public interface UserClient {

    @GetMapping("/by-username")
    UserDTO getUserByUsername(@RequestParam("username") String username);

    @GetMapping("/by-email")
    UserDTO getUserByEmail(@RequestParam("email") String email);

}
