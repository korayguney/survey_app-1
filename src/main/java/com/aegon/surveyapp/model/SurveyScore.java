package com.aegon.surveyapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SurveyScore {

    private String surveyTopic;
    private long totalScore;

}
