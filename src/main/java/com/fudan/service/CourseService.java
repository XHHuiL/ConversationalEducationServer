package com.fudan.service;


import com.fudan.dao.ContentDao;
import com.fudan.dao.CourseDao;
import com.fudan.dao.NoteDao;
import com.fudan.dao.UserConnectCourseDao;
import com.fudan.entity.Course;
import com.fudan.entity.CourseExample;
import com.fudan.entity.Note;
import com.fudan.entity.UserConnectCourse;
import org.springframework.stereotype.Service;

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