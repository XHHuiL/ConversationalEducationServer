package com.fudan.controller;


import com.fudan.response.OptionsResponse;
import com.fudan.service.OptionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class OptionController {

    private final OptionService optionService;

    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping(value = "/options/{contentId}")
    public OptionsResponse getOptions(@PathVariable Integer contentId) {
        return optionService.getOptions(contentId);
    }

}