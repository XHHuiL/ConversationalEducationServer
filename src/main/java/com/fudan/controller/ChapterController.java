package com.fudan.controller;

import com.fudan.entity.Chapter;
import com.fudan.service.ChapterService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ChapterController {

    private final ChapterService chapterService;

    public ChapterController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }


    @GetMapping(value = "/chapters/{courseId}")
    public List<Chapter> allChapters(@PathVariable Integer courseId) {
        return chapterService.getChaptersByCourseId(courseId);
    }

}