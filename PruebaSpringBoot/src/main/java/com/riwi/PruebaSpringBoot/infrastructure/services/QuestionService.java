package com.riwi.PruebaSpringBoot.infrastructure.services;

import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.PruebaSpringBoot.api.dto.request.OptionRequest;
import com.riwi.PruebaSpringBoot.api.dto.request.QuestionRequest;
import com.riwi.PruebaSpringBoot.api.dto.response.QuestionResponse;
import com.riwi.PruebaSpringBoot.domain.entities.OptionQuestion;
import com.riwi.PruebaSpringBoot.domain.entities.Question;
import com.riwi.PruebaSpringBoot.domain.repositories.QuestionRepository;
import com.riwi.PruebaSpringBoot.infrastructure.abstract_services.IQuestionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestionService implements IQuestionService{
    
    @Autowired
    private final QuestionRepository questionRepository;

    @Override
    public QuestionResponse create(QuestionRequest request) {
        Question question = this.requestToEntity(request);
        return this.entityToResponse(this.questionRepository.save(question));
    }

    @Override
    public QuestionResponse get(Long id) {
        return this.entityToResponse(this.find(id));
    }

    @Override
    public QuestionResponse update(QuestionRequest request, Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<QuestionResponse> getAll(int page, int size) {
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
    

    private Question find(Long id) {
        return this.questionRepository.findById(id).orElseThrow();
    }

    private QuestionResponse entityToResponse(Question entity) {
        QuestionResponse response = new QuestionResponse();

        BeanUtils.copyProperties(entity, response);

        return response;
    }

    private Question requestToEntity(QuestionRequest request) {
        Question entity = new Question();

        BeanUtils.copyProperties(request, entity);
        request.setOptions(entity.getOptionQuestion().stream()
        .map(this::optionToResponse).collect(Collectors.toList()));
        return entity;
    }

    private OptionRequest  optionToResponse(OptionQuestion entity) {
        OptionRequest response = new OptionRequest();

        BeanUtils.copyProperties(entity, response);

        return response;
    }
}
