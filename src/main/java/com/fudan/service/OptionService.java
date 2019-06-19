package com.fudan.service;


import com.fudan.dao.OptionDao;
import com.fudan.entity.Option;
import com.fudan.response.OptionsResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {

    private final OptionDao optionDao;


    public OptionService(OptionDao optionDao) {
        this.optionDao = optionDao;
    }

    public OptionsResponse getOptions(Integer contentId) {
        List<Option> options = optionDao.selectByContentId(contentId);
        OptionsResponse response = new OptionsResponse();
        response.setContentId(contentId);
        StringBuilder text = new StringBuilder();
        String temp;
        for (Option option : options
                ) {
            temp = (char) ('A' + option.getOptionId() - 1) + ". ";
            text.append(temp).append(option.getText()).append("\n");
        }
        response.setText(text.toString());
        return response;
    }
}