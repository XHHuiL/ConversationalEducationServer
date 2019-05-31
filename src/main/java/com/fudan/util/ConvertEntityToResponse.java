package com.fudan.util;


import com.fudan.entity.Course;
import com.fudan.response.CourseResponse;

import java.util.ArrayList;
import java.util.List;

public class ConvertEntityToResponse {

    public static CourseResponse convertCourse(Course course) {
        return new CourseResponse(course.getId(), course.getName(), course.getTeacherId(), course.getImage(), 10);
    }

    public static List<CourseResponse> convertCourseList(List<Course> courses){
        List<CourseResponse> courseResponses = new ArrayList<>();
        for (Course course : courses) {
            courseResponses.add(ConvertEntityToResponse.convertCourse(course));
        }
        return courseResponses;
    }

}