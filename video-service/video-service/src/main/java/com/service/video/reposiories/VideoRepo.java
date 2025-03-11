package com.service.video.reposiories;

import com.service.video.document.Video;
import com.service.video.dtos.VideoDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepo extends MongoRepository<Video,String> {
    List<Video> findByVideoTitleContainingIgnoreCaseOrVideoDescContainingIgnoreCase(String titleKeyword,String descKeyword);
    List<Video> findByCourseId(String courseId);
}
