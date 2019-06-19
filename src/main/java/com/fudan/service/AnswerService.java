package com.fudan.service;

import com.fudan.dao.AnswerDao;
import com.fudan.entity.Answer;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    private final AnswerDao answerDao;


    public AnswerService(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    public void create(Answer answer) {
        answerDao.insert(answer);
    }
}