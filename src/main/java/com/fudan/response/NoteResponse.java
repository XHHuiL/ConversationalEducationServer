package com.fudan.response;


public class NoteResponse {

    private Integer id;

    private String studentId;

    private Integer contentId;

    private String text;

    private String ContentText;

    public NoteResponse(Integer id, String studentId, Integer contentId, String text, String contentText) {
        this.id = id;
        this.studentId = studentId;
        this.contentId = contentId;
        this.text = text;
        ContentText = contentText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getContentText() {
        return ContentText;
    }

    public void setContentText(String contentText) {
        ContentText = contentText;
    }
}