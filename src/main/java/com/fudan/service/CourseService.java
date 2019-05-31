package com.fudan.service;


import com.fudan.dao.CourseDao;
import com.fudan.entity.Course;
import com.fudan.entity.CourseExample;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseDao courseDao;

    public CourseService(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public List<Course> getCourses() {
        return courseDao.selectByExample(new CourseExample());
    }

    public List<Course> getSelectedCourses(String userId) {
        return courseDao.selectedCourses(userId);
    }

    public List<Course> getUnselectedCourses(String userId) {
        return courseDao.unselectedCourses(userId);
    }

    public void update(Course course) {
        courseDao.updateByPrimaryKeySelective(course);
    }
}