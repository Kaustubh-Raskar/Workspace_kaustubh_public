package com.kaustubh.rentvideo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kaustubh.rentvideo.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
}

