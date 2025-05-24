package com.kaustubh.rentalvideowith_jwt_auth.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaustubh.rentalvideowith_jwt_auth.model.Rental;
import com.kaustubh.rentalvideowith_jwt_auth.model.User;
import com.kaustubh.rentalvideowith_jwt_auth.model.Video;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByUserAndReturnDateIsNull(User user);
    Optional<Rental> findByUserAndVideoAndReturnDateIsNull(User user, Video video);
}