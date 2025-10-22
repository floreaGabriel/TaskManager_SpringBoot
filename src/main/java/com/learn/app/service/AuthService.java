package com.learn.app.service;

import com.learn.app.dto.UserLoginDTO;
import com.learn.app.model.User;
import com.learn.app.repository.UserRepository;
import com.learn.app.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public String login(UserLoginDTO loginDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getUsername(),
                            loginDTO.getPassword()
                    )
            );

            User user = userRepository.findUserByUsername(loginDTO.getUsername())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            return jwtUtil.generateToken(user.getUsername(), user.getId());

        } catch (BadCredentialsException e) {
            throw new RuntimeException("Invalid username or password");
        }
    }
}
