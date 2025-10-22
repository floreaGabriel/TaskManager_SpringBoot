package com.learn.app.service;

import com.learn.app.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learn.app.dto.UserRegisterDTO;
import com.learn.app.dto.UserResponseDTO;
import com.learn.app.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDTO registerUser(UserRegisterDTO registerDTO) {
        if (userRepository.existsUserByUsername(registerDTO.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        User savedUser = userRepository.save(user);

        return new UserResponseDTO(savedUser.getId(), savedUser.getUsername());
    }
}
