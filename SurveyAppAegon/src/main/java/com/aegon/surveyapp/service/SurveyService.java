package com.aegon.surveyapp.service;

import com.aegon.surveyapp.dto.SurveyDTO;
import com.aegon.surveyapp.model.Survey;
import com.aegon.surveyapp.model.SurveyScore;
import com.aegon.surveyapp.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class SurveyService {

    private final SurveyRepository surveyRepository;

    public SurveyDTO create(SurveyDTO surveyDTO) {
        log.debug("Request to create Survey : {}", surveyDTO);
        return mapToDto(this.surveyRepository.save(
                new Survey(
                        surveyDTO.getSurveyTopic(),
                        surveyDTO.getSurveyQuestion(),
                        surveyDTO.getSurveyScore(),
                        surveyDTO.getSurveyFeedback()
                )
        ));
    }

    public List<SurveyDTO> findByTopic(String topic) {
        log.debug("Request to get Surveys according to topic");
        return this.surveyRepository.findBySurveyTopic(topic)
                .stream()
                .map(SurveyService::mapToDto)
                .collect(Collectors.toList());
    }

    public List<SurveyDTO> findAll() {
        log.debug("Request to get all Surveys");
        return this.surveyRepository.findAll()
                .stream()
                .map(SurveyService::mapToDto)
                .collect(Collectors.toList());
    }

    public List<SurveyScore> findSurveyTotalScores() {
        return this.surveyRepository.findSurveyTotalScores();
    }

    public static SurveyDTO mapToDto(Survey survey) {
        if (survey != null) {
            return new SurveyDTO(
                    survey.getId(),
                    survey.getSurveyTopic(),
                    survey.getSurveyQuestion(),
                    survey.getSurveyScore(),
                    survey.getSurveyFeedback()
            );
        }
        return null;
    }

}
