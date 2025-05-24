package com.kaustubh.rentalvideowith_jwt_auth.service;

import com.kaustubh.rentalvideowith_jwt_auth.dto.RegisterRequest;
import com.kaustubh.rentalvideowith_jwt_auth.model.Role;
import com.kaustubh.rentalvideowith_jwt_auth.model.User;
import com.kaustubh.rentalvideowith_jwt_auth.dto.LoginRequest;
import com.kaustubh.rentalvideowith_jwt_auth.repository.UserRepository;
import com.kaustubh.rentalvideowith_jwt_auth.security.JwtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public void register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists!");
        }

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .role(request.getRole() != null ? request.getRole() : Role.CUSTOMER)
                .build();

        userRepository.save(user);
    }

    public String login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = (User) authentication.getPrincipal();
        return jwtService.generateToken(user);
    }
}