package com.service.video.services;

import com.service.video.dtos.VideoDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VideoService {

    public VideoDto createVideo(VideoDto videoDto);
    List<VideoDto> getAllVideo();
    VideoDto getVideoById(String videoId);
    VideoDto updateVideo(VideoDto videoDto,String videoId);
    String deleteVideo(String videoId);

    List<VideoDto> getVideoOfCourse(String courseId);
    List<VideoDto> searchVideoByKeyword(String keyword);
}
