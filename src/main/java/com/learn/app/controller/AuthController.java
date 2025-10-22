package com.learn.app.controller;

import com.learn.app.dto.UserLoginDTO;
import com.learn.app.dto.UserRegisterDTO;
import com.learn.app.dto.UserResponseDTO;
import com.learn.app.service.AuthService;
import com.learn.app.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@Valid @RequestBody UserRegisterDTO registerDTO) {
        UserResponseDTO response = userService.registerUser(registerDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@Valid @RequestBody UserLoginDTO loginDTO) {
        String token = authService.login(loginDTO);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        response.put("message", "Login successful");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Welcome to Task Manager API!");
    }
}
