package com.kaustubh.rentalvideowith_jwt_auth.service;


import com.kaustubh.rentalvideowith_jwt_auth.exception.ResourceNotFoundException;
import com.kaustubh.rentalvideowith_jwt_auth.model.Video;
import com.kaustubh.rentalvideowith_jwt_auth.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public List<Video> getAllAvailableVideos() {
        return videoRepository.findByAvailableTrue();
    }

    public Video createVideo(Video video) {
        return videoRepository.save(video);
    }

    public Video updateVideo(Long id, Video updatedVideo) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Video not found with id: " + id));
        video.setTitle(updatedVideo.getTitle());
        video.setDirector(updatedVideo.getDirector());
        video.setGenre(updatedVideo.getGenre());
        video.setAvailable(updatedVideo.isAvailable());
        return videoRepository.save(video);
    }

    public void deleteVideo(Long id) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Video not found with id: " + id));
        videoRepository.delete(video);
    }
}