package com.riwi.PruebaSpringBoot.infrastructure.abstract_services;

import com.riwi.PruebaSpringBoot.api.dto.request.QuestionRequest;
import com.riwi.PruebaSpringBoot.api.dto.response.QuestionResponse;

public interface IQuestionService extends CrudService<QuestionRequest, QuestionResponse, Long>{
    
}
