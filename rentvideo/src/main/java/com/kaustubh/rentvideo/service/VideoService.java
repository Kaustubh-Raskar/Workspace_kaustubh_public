package com.kaustubh.rentvideo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaustubh.rentvideo.exception.ResourceNotFoundException;
import com.kaustubh.rentvideo.model.Video;
import com.kaustubh.rentvideo.repository.VideoRepository;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public List<Video> getAllAvailableVideos() {
        return videoRepository.findAll();
    }

    public Video createVideo(Video video) {
        return videoRepository.save(video);
    }

    public Video updateVideo(Long id, Video updatedVideo) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Video not found"));
        video.setTitle(updatedVideo.getTitle());
        video.setDirector(updatedVideo.getDirector());
        video.setGenre(updatedVideo.getGenre());
        video.setAvailable(updatedVideo.isAvailable());
        return videoRepository.save(video);
    }

    public void deleteVideo(Long id) {
        videoRepository.deleteById(id);
    }
}
