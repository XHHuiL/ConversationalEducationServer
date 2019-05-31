package com.fudan.controller;

import com.fudan.entity.Course;
import com.fudan.response.CourseResponse;
import com.fudan.service.CourseService;
import com.fudan.util.ConvertEntityToResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return ConvertEntityToResponse.convertCourseList(courseService.getCourses());
    }

    @GetMapping(value = "/selected/{userId}")
    public List<CourseResponse> selectedCourses(@PathVariable String userId){
        return ConvertEntityToResponse.convertCourseList(courseService.getSelectedCourses(userId));
    }

    @GetMapping(value = "/unselected/{userId}")
    public List<CourseResponse> unselectedCourses(@PathVariable String userId){
        return ConvertEntityToResponse.convertCourseList(courseService.getUnselectedCourses(userId));
    }

    @PutMapping(value = "/{id}")
    public void updateCourse(@PathVariable int id, @RequestBody Course course){
        System.out.println(course.getTeacherId());
        courseService.update(course);
    }

}