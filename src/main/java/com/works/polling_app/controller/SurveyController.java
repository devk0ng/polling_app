package com.works.polling_app.controller;


import com.works.polling_app.domain.Survey;
import com.works.polling_app.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/api")
public class SurveyController {

    private final SurveyService surveyService;

    @GetMapping("/survey")
    public List<Survey> getAllPolling(){
        return surveyService.findSurveys();
    }
}
