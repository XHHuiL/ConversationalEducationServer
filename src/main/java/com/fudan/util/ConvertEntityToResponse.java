package com.fudan.util;


import com.fudan.entity.Course;
import com.fudan.response.CourseResponse;

public class ConvertEntityToResponse {

    public static CourseResponse convertCourse(Course course) {
        return new CourseResponse(course.getId(), course.getName(), course.getTeacherId(), course.getImage(), 10);
    }

}