package com.service.video;

import com.service.video.document.Video;
import com.service.video.reposiories.VideoRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideoServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VideoServiceApplication.class, args);
	}

	@Bean
	ModelMapper modelMapper(){
		return  new ModelMapper();
	}

	@Autowired
	VideoRepo videoRepo;
	@Override
	public void run(String... args) throws Exception {
//		Video video=new Video();
//		video.setVideoTitle("intro to microservices");
//		video.setVideoDesc("This video contain introduction to microservices");
//		video.setContentType("MP4");
//		video.setFilePath("/upload/videofile");
//		videoRepo.save(video);
//		System.out.println("video saved successfully");
	}
}
