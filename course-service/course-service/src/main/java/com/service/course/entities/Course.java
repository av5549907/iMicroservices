package com.service.course.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="courses")
@Data
public class Course {

    @Id
    private  String courseId;
    private  String title;
    private  String shortDesc;
    @JsonProperty("long_description")
    private String longDesc;
    private double price;
    private  boolean live=false;
    private double discount;
    private  String banner;
    private Date createdDate;
    private String bannerContentType;
    private String categoryId;
    public  String getBannerUrl(){
        return "";
    }

}
