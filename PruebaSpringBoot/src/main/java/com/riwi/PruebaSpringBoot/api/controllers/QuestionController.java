package com.riwi.PruebaSpringBoot.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.PruebaSpringBoot.api.dto.request.QuestionRequest;
import com.riwi.PruebaSpringBoot.api.dto.response.QuestionResponse;
import com.riwi.PruebaSpringBoot.infrastructure.services.QuestionService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/questions")
public class QuestionController {
    
    @Autowired
    private final QuestionService questionService;

    @PostMapping
    public ResponseEntity<QuestionResponse> create(@RequestBody QuestionRequest question){
        return ResponseEntity.ok(this.questionService.create(question));
    }
}
