package com.kaustubh.rentalvideowith_jwt_auth.service;


import com.kaustubh.rentalvideowith_jwt_auth.exception.ResourceNotFoundException;
import com.kaustubh.rentalvideowith_jwt_auth.model.Rental;
import com.kaustubh.rentalvideowith_jwt_auth.model.User;
import com.kaustubh.rentalvideowith_jwt_auth.model.Video;
import com.kaustubh.rentalvideowith_jwt_auth.repository.RentalRepository;
import com.kaustubh.rentalvideowith_jwt_auth.repository.UserRepository;
import com.kaustubh.rentalvideowith_jwt_auth.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VideoRepository videoRepository;

    public void rentVideo(Long videoId, String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new ResourceNotFoundException("Video not found"));

        // Check if user has already rented 2 videos
        List<Rental> activeRentals = rentalRepository.findByUserAndReturnDateIsNull(user);
        if (activeRentals.size() >= 2) {
            throw new IllegalStateException("You already have 2 active rentals.");
        }

        // Mark video as not available
        video.setAvailable(false);
        videoRepository.save(video);

        // Create a new rental record
        Rental rental = new Rental();
        rental.setUser(user);
        rental.setVideo(video);
        rental.setRentalDate(LocalDateTime.now());
        rentalRepository.save(rental);
    }

    public void returnVideo(Long videoId, String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Video video = videoRepository.findById(videoId)
                .orElseThrow(() -> new ResourceNotFoundException("Video not found"));

        Rental rental = rentalRepository.findByUserAndVideoAndReturnDateIsNull(user, video)
                .orElseThrow(() -> new IllegalStateException("No active rental found for this video."));

        rental.setReturnDate(LocalDateTime.now());
        rentalRepository.save(rental);

        video.setAvailable(true);
        videoRepository.save(video);
    }
}