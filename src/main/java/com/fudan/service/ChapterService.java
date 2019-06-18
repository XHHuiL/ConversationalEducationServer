package com.fudan.service;

import com.fudan.dao.ChapterDao;
import com.fudan.entity.Chapter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterService {

    private final ChapterDao chapterDao;

    public ChapterService(ChapterDao chapterDao) {
        this.chapterDao = chapterDao;
    }

    public List<Chapter> getChaptersByCourseId(Integer id) {
        return chapterDao.selectByCourseId(id);
    }

    public Integer getRelevantCourseId(Integer id){
        return chapterDao.selectByPrimaryKey(id).getCourseId();
    }
}