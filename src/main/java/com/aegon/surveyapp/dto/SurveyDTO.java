package com.aegon.surveyapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SurveyDTO {

    private int id;
    private String surveyTopic;
    private String surveyQuestion;
    private int surveyScore;
    private String surveyFeedback;

}
