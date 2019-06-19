package com.fudan.service;

import com.fudan.dao.AnswerDao;
import com.fudan.entity.Answer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnswerService {

    private final AnswerDao answerDao;


    public AnswerService(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void create(Answer answer) {
        answerDao.insert(answer);
    }
}