package com.kaustubh.rentalvideowith_jwt_auth.dto;

import com.kaustubh.rentalvideowith_jwt_auth.model.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Role role; 

}
