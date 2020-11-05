package com.aegon.surveyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SurveyappApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveyappApplication.class, args);
    }

}
