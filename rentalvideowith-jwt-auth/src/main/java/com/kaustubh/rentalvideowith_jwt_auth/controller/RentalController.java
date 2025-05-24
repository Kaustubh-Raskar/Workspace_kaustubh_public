package com.kaustubh.rentalvideowith_jwt_auth.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaustubh.rentalvideowith_jwt_auth.service.RentalService;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @PostMapping("/{videoId}/rent")
    public ResponseEntity<?> rentVideo(@PathVariable Long videoId, Principal principal) {
        rentalService.rentVideo(videoId, principal.getName());
        return ResponseEntity.ok("Video rented successfully");
    }

    @PostMapping("/{videoId}/return")
    public ResponseEntity<?> returnVideo(@PathVariable Long videoId, Principal principal) {
        rentalService.returnVideo(videoId, principal.getName());
        return ResponseEntity.ok("Video returned successfully");
    }
}
