package com.kaustubh.rentvideo.dto;

import com.kaustubh.rentvideo.model.Role;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;


}
