package com.riwi.PruebaSpringBoot.api.dto.response;

import java.util.List;

import com.riwi.PruebaSpringBoot.util.enums.QuestionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResponse {
    
    private Long id;

    private String text;

    private QuestionType type;

    private boolean active;

    private List<OptionResponse> options;
}
