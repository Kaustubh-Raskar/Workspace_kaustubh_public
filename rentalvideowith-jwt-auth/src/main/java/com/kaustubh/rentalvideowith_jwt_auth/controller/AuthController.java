package com.kaustubh.rentalvideowith_jwt_auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaustubh.rentalvideowith_jwt_auth.dto.JwtResponse;
import com.kaustubh.rentalvideowith_jwt_auth.dto.LoginRequest;
import com.kaustubh.rentalvideowith_jwt_auth.dto.RegisterRequest;
import com.kaustubh.rentalvideowith_jwt_auth.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        authService.register(request);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        String token = authService.login(request);
        return ResponseEntity.ok(new JwtResponse(token));
    }
}

