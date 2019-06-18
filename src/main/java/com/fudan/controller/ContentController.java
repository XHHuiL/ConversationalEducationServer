package com.fudan.controller;

import com.fudan.entity.Content;
import com.fudan.service.ContentService;
import com.fudan.util.MapFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class ContentController {

    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping(value = "/contents/{chapterId}")
    public Map allContents(@PathVariable Integer chapterId) {
        String teacherHeadSculpture = contentService.getTeacherHeadSculpture(chapterId);
        List<Content> contents = contentService.getContentsByChapterId(chapterId);
        return MapFactory.contentsMap(teacherHeadSculpture, contents);
    }
}