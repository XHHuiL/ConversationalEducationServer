package com.fudan.response;


public class CourseResponse {
    private int id;
    private String name;
    private String teacher_id;
    private String image;
    private int student_num;

    public CourseResponse(int id, String name, String teacher_id, String image, int student_num) {
        this.id = id;
        this.name = name;
        this.teacher_id = teacher_id;
        this.image = image;
        this.student_num = student_num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStudent_num() {
        return student_num;
    }

    public void setStudent_num(int student_num) {
        this.student_num = student_num;
    }
}