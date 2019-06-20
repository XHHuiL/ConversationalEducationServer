package com.fudan.util;

import com.fudan.entity.Content;
import com.fudan.entity.Course;
import com.fudan.entity.User;
import com.fudan.response.CourseResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MapFactory {
    public static final String CREATE = "create";
    public static final String UPDATE = "update";
    public static final String DELETE = "delete";

    public static Map idNotExitMap() {
        MapBuilder builder = new MapBuilder();
        builder.notExitId();
        builder.message("can not find entity with this id");
        return builder.getMap();
    }

    public static Map idMismatchMap() {
        MapBuilder builder = new MapBuilder();
        builder.mismatchId();
        builder.message("id in the path mismatch id in the body");
        return builder.getMap();
    }

    public static Map coursesMap(List<CourseResponse> courses) {
        MapBuilder builder = new MapBuilder();
        builder.courses(courses);
        return builder.getMap();
    }

    public static Map courseMap(Course course) {
        MapBuilder builder = new MapBuilder();
        builder.course(course);
        return builder.getMap();
    }

    public static Map contentsMap(String name, String headSculpture, List<Content> contents) {
        MapBuilder builder = new MapBuilder();
        builder.teacherName(name);
        builder.headSculpture(headSculpture);
        builder.contents(contents);
        return builder.getMap();
    }

    public static Map userMap(User user) {
        MapBuilder builder = new MapBuilder();
        builder.user(user);
        return builder.getMap();
    }

    public static Map successMap(String option) {
        MapBuilder builder = new MapBuilder();
        builder.ok();
        builder.message(option + " data success");
        return builder.getMap();
    }

    public static Map nullFieldMap() {
        MapBuilder builder = new MapBuilder();
        builder.nullField();
        builder.message("request body exist null field");
        return builder.getMap();
    }

    public static Map alreadyTakeMap() {
        MapBuilder builder = new MapBuilder();
        builder.alreadyTake();
        builder.message("the student has already taken this course");
        return builder.getMap();
    }

    public static Map notTakeMap() {
        MapBuilder builder = new MapBuilder();
        builder.notTake();
        builder.message("the student has not taken this course");
        return builder.getMap();
    }

    private static class MapBuilder {
        Map<String, Object> map = new HashMap<>();

        private void ok() {
            map.put("code", "ok");
        }

        private void notExitId() {
            map.put("code", "non-existent id");
        }

        private void mismatchId() {
            map.put("code", "mismatch id");
        }

        private void nullField() {
            map.put("code", "null field");
        }

        private void alreadyTake() {
            map.put("code", "already take");
        }

        private void notTake() {
            map.put("code", "not take");
        }

        private void message(String message) {
            map.put("message", message);
        }

        private void courses(List<CourseResponse> courses) {
            map.put("courses", courses);
        }

        private void course(Course course) {
            map.put("course", course);
        }

        private void user(User user) {
            map.put("info", user);
        }

        private void teacherName(String name){
            map.put("teacherName", name);
        }

        private void headSculpture(String headSculpture) {
            map.put("headSculpture", headSculpture);
        }

        private void contents(List<Content> contents) {
            map.put("contents", contents);
        }

        private Map getMap() {
            return map;
        }
    }
}