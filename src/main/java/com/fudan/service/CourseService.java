package com.fudan.service;


import com.fudan.dao.CourseDao;
import com.fudan.dao.UserConnectCourseDao;
import com.fudan.entity.Course;
import com.fudan.entity.CourseExample;
import com.fudan.entity.UserConnectCourse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseDao courseDao;
    private final UserConnectCourseDao connectDao;

    public CourseService(CourseDao courseDao, UserConnectCourseDao connectDao) {
        this.courseDao = courseDao;
        this.connectDao = connectDao;
    }

    public List<Course> getCourses() {
        return courseDao.selectByExample(new CourseExample());
    }

    public Course getCourseById(Integer id){
        return courseDao.selectByPrimaryKey(id);
    }

    public List<Course> getSelectedCourses(String userId) {
        return courseDao.selectedCourses(userId);
    }

    public List<Course> getUnselectedCourses(String userId) {
        return courseDao.unselectedCourses(userId);
    }

    public List<Course> getOfferedCourses(String teacherId) {
        return courseDao.offeredCourses(teacherId);
    }

    public void update(Course course) {
        courseDao.updateByPrimaryKeySelective(course);
    }

    public void create(Course course) {
        courseDao.insert(course);
    }

    public boolean alreadyTake(UserConnectCourse connect){
        return connectDao.selectByUserIdAndCourseId(connect) != null;
    }

    public void take(UserConnectCourse connect){
        connectDao.insert(connect);
    }

    public void drop(UserConnectCourse connect) {
        connectDao.deleteByUserIdAndCourseId(connect);
    }

    public String getRelevantTeacherId(Integer id){
        return courseDao.selectByPrimaryKey(id).getTeacherId();
    }
}