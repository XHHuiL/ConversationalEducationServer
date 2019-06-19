package com.fudan.service;

import com.fudan.dao.ContentDao;
import com.fudan.entity.Content;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContentService {

    private final ContentDao contentDao;
    private final ChapterService chapterService;
    private final CourseService courseService;
    private final UserService userService;

    public ContentService(ContentDao contentDao, ChapterService chapterService, CourseService courseService, UserService userService) {
        this.contentDao = contentDao;
        this.chapterService = chapterService;
        this.courseService = courseService;
        this.userService = userService;
    }

    public List<Content> getContentsByChapterId(Integer id) {
        return contentDao.selectByChapterId(id);
    }

    public Integer getRelevantChapterId(Integer id){
        return contentDao.selectByPrimaryKey(id).getChapterId();
    }

    public String getTeacherHeadSculpture(Integer id) {
        return
                userService.getHeadSculpture(
                        courseService.getRelevantTeacherId(
                                chapterService.getRelevantCourseId(id)));
    }
}