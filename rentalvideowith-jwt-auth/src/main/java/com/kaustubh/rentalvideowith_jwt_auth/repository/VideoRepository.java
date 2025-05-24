package com.kaustubh.rentalvideowith_jwt_auth.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kaustubh.rentalvideowith_jwt_auth.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findByAvailableTrue();
}