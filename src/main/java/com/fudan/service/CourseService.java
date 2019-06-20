package com.fudan.service;


import com.fudan.dao.ContentDao;
import com.fudan.dao.CourseDao;
import com.fudan.dao.NoteDao;
import com.fudan.dao.UserConnectCourseDao;
import com.fudan.entity.Course;
import com.fudan.entity.CourseExample;
import com.fudan.entity.Note;
import com.fudan.entity.UserConnectCourse;
import com.fudan.response.CourseResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private final CourseDao courseDao;
    private final UserConnectCourseDao connectDao;
    private final NoteDao noteDao;
    private final ChapterService chapterService;
    private final ContentDao contentDao;
    private final NoteService noteService;

    public CourseService(CourseDao courseDao, UserConnectCourseDao connectDao, NoteDao noteDao, ChapterService chapterService, ContentDao contentDao, NoteService noteService) {
        this.courseDao = courseDao;
        this.connectDao = connectDao;
        this.noteDao = noteDao;
        this.chapterService = chapterService;
        this.contentDao = contentDao;
        this.noteService = noteService;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public List<CourseResponse> getCourses() {
        List<Course> courses = courseDao.selectByExample(new CourseExample());
        List<CourseResponse> courseResponses = new ArrayList<>();
        for (Course course :courses
                ) {
            int num = connectDao.selectByCourseId(course.getId()).size();
            courseResponses.add(new CourseResponse(course.getId(), course.getName(), course.getTeacherId(), course.getImage(), course.getDescription(), num));
        }
        return courseResponses;
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

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void update(Course course) {
        courseDao.updateByPrimaryKeySelective(course);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void create(Course course) {
        courseDao.insert(course);
    }

    public boolean alreadyTake(UserConnectCourse connect){
        return connectDao.selectByUserIdAndCourseId(connect) != null;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void take(UserConnectCourse connect){
        connectDao.insert(connect);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void drop(UserConnectCourse connect) {
        connectDao.deleteByUserIdAndCourseId(connect);
        List<Note> notes = noteDao.selectByStudentId(connect.getUserId());
        for (Note note:notes
             ) {
            if (chapterService.getRelevantCourseId(contentDao.selectByPrimaryKey(note.getContentId()).getChapterId()).
                    equals(connect.getCourseId())){
                noteService.delete(note.getId());
            }
        }
    }

    public String getRelevantTeacherId(Integer id){
        return courseDao.selectByPrimaryKey(id).getTeacherId();
    }
}