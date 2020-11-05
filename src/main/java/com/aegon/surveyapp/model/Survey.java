package com.aegon.surveyapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="survey")
public class Survey extends AbstractEntity {

    @NotNull
    @Column(name = "topic", nullable = false)
    private String surveyTopic;

    @NotNull
    @Column(name = "question", nullable = false)
    private String surveyQuestion;

    @NotNull
    @Column(name = "score", nullable = false)
    private int surveyScore;

    @NotNull
    @Column(name = "feedback", nullable = false)
    private String surveyFeedback;

}
