package com.service.video.dtos.controllers;


import com.service.video.dtos.VideoDto;
import com.service.video.services.VideoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/videos")
public class VideoController {

    VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping
    ResponseEntity<VideoDto> createVideo(@RequestBody VideoDto videoDto){
        System.out.println("title : "+videoDto.getVideoTitle());
        return new ResponseEntity<>(videoService.createVideo(videoDto), HttpStatus.CREATED);
    }

    @GetMapping("/{videoId}")
    ResponseEntity< VideoDto> getVideoById(@PathVariable String videoId){
        return  new ResponseEntity<>(videoService.getVideoById(videoId),HttpStatus.OK);
    }
    @GetMapping
    ResponseEntity<List<VideoDto>> getAllVideo(){
        return  new ResponseEntity<>(videoService.getAllVideo(),HttpStatus.OK);
    }
    @PutMapping("/{videoId}")
    ResponseEntity< VideoDto> updateVideo(@RequestBody VideoDto videoDto,@PathVariable String videoId){
        return  new ResponseEntity<>(videoService.updateVideo(videoDto,videoId),HttpStatus.OK);
    }
    @GetMapping("/course/{courseId}")
    ResponseEntity<List<VideoDto>> getVideoOfCourse(@PathVariable String courseId){
        return  new ResponseEntity<>(videoService.getVideoOfCourse(courseId),HttpStatus.OK);
    }

   @GetMapping("/search")
    ResponseEntity<List<VideoDto>> searchVideo(
            @RequestParam(value = "keyWord",required = false) String keyWord
   ){
        return new ResponseEntity<>(videoService.searchVideoByKeyword(keyWord),HttpStatus.OK);
   }


}
