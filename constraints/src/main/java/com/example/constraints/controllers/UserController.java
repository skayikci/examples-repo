package com.example.constraints.controllers;

import com.example.constraints.controllers.dto.UserDTO;
import com.example.constraints.services.UserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // for better responseBodies :)
@RequestMapping("/users")
@RequiredArgsConstructor // for better autowiring
public class UserController {

    private final UserService userService;

    @GetMapping
    public Page<UserDTO> getAllUsers(Pageable pageable) {
        return userService.getAllUsers(pageable);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDTO userDTO) {
        userService.create(userDTO);
        return ResponseEntity.ok().build();
    }

}
