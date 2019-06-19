package com.fudan.controller;

import com.fudan.entity.Answer;
import com.fudan.service.AnswerService;
import com.fudan.util.MapFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping(value = "/answer")
    public Map uploadAnswer(@RequestBody Answer answer) {
        if (answer.getStudentId() == null || answer.getContentId() == null || answer.getSelectedOption() == null) {
            return MapFactory.nullFieldMap();
        }
        answerService.create(answer);
        return MapFactory.successMap(MapFactory.CREATE);
    }

}