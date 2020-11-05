package com.aegon.surveyapp.controller;

import com.aegon.surveyapp.dto.SurveyDTO;
import com.aegon.surveyapp.model.SurveyScore;
import com.aegon.surveyapp.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/surveys")
public class SurveyController {

    private final SurveyService surveyService;

    @GetMapping
    public List<SurveyDTO> findAll() {
        return this.surveyService.findAll();
    }

    @GetMapping("/{topic}")
    public List<SurveyDTO> findByTopic(@PathVariable String topic) {
        return this.surveyService.findByTopic(topic);
    }

    @GetMapping("/scores")
    public List<SurveyScore> findTotalScores() {
        /*List<SurveyDTO> surveys = this.surveyService.findAll();
        List<SurveyScore> scores = new ArrayList<>();
        for (SurveyDTO s: surveys) {
            scores.add(new SurveyScore(s.getSurveyTopic(),s.getSurveyScore()));
        }
        return scores;
         */
        return this.surveyService.findSurveyTotalScores();
    }

    @PostMapping
    public SurveyDTO create(@RequestBody SurveyDTO surveyDTO) {
        return this.surveyService.create(surveyDTO);
    }


}
