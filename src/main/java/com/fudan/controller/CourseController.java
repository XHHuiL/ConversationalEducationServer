package com.fudan.controller;

import com.fudan.entity.Course;
import com.fudan.entity.UserConnectCourse;
import com.fudan.service.CourseService;
import com.fudan.service.UserService;
import com.fudan.util.ConvertEntityToResponse;
import com.fudan.util.MapFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class CourseController {

    private final CourseService courseService;
    private final UserService userService;

    @Autowired
    public CourseController(CourseService courseService, UserService userService) {
        this.courseService = courseService;
        this.userService = userService;
    }

    @GetMapping(value = "/course/all")
    public Map allCourses() {
        return MapFactory.coursesMap(ConvertEntityToResponse.convertCourseList(courseService.getCourses()));
    }

    @GetMapping(value = "/course/selected/{userId}")
    public Map selectedCourses(@PathVariable String userId) {
        if (userService.getUserByUUID(userId) == null) {
            return MapFactory.idNotExitMap();
        }
        return MapFactory.coursesMap(ConvertEntityToResponse.convertCourseList(courseService.getSelectedCourses(userId)));
    }

    @GetMapping(value = "/course/unselected/{userId}")
    public Map unselectedCourses(@PathVariable String userId) {
        if (userService.getUserByUUID(userId) == null) {
            return MapFactory.idNotExitMap();
        }
        return MapFactory.coursesMap(ConvertEntityToResponse.convertCourseList(courseService.getUnselectedCourses(userId)));
    }

    @GetMapping(value = "/course/offered/{teacherId}")
    public Map offeredCourses(@PathVariable String teacherId) {
        if (userService.getUserByUUID(teacherId) == null) {
            return MapFactory.idNotExitMap();
        }
        return MapFactory.coursesMap(ConvertEntityToResponse.convertCourseList(courseService.getOfferedCourses(teacherId)));
    }

    @GetMapping(value = "/course/{id}")
    public Map getCourse(@PathVariable int id) {
        Course course = courseService.getCourseById(id);
        if (course == null) {
            return MapFactory.idNotExitMap();
        }
        return MapFactory.courseMap(course);
    }

    @PutMapping(value = "/course/{id}")
    public Map updateCourse(@PathVariable int id, @RequestBody Course course) {
        if (id != course.getId()) {
            return MapFactory.idMismatchMap();
        }
        if (courseService.getCourseById(id) == null) {
            return MapFactory.idNotExitMap();
        }
        courseService.update(course);
        return MapFactory.successMap(MapFactory.UPDATE);
    }

    @PostMapping(value = "/course")
    public Map createCourse(@RequestBody Course course) {
        if (course.getName() == null || course.getTeacherId() == null) {
            return MapFactory.nullFieldMap();
        }
        courseService.create(course);
        return MapFactory.successMap(MapFactory.CREATE);
    }

    @PostMapping(value = "/course/take")
    public Map takeCourse(@RequestBody UserConnectCourse connect) {
        if (connect.getUserId() == null || connect.getCourseId() == null) {
            return MapFactory.nullFieldMap();
        }
        if (courseService.alreadyTake(connect)) {
            return MapFactory.alreadyTakeMap();
        }
        courseService.take(connect);
        return MapFactory.successMap(MapFactory.CREATE);
    }

    @DeleteMapping(value = "/course/drop")
    public Map dropCourse(@RequestBody UserConnectCourse connect) {
        if (connect.getUserId() == null || connect.getCourseId() == null) {
            return MapFactory.nullFieldMap();
        }
        if (!courseService.alreadyTake(connect)) {
            return MapFactory.notTakeMap();
        }
        courseService.drop(connect);
        return MapFactory.successMap(MapFactory.DELETE);
    }
}