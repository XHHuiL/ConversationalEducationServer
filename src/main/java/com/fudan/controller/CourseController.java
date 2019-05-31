package com.fudan.controller;

import com.fudan.entity.Course;
import com.fudan.response.CourseResponse;
import com.fudan.service.CourseService;
import com.fudan.util.ConvertEntityToResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping(value = "/all")
    public List<CourseResponse> allCourses(){
        List<Course> courses = courseService.getCourses();
        List<CourseResponse> courseResponses = new ArrayList<>();
        for (Course course : courses) {
            courseResponses.add(ConvertEntityToResponse.convertCourse(course));
        }
        return courseResponses;
    }

}