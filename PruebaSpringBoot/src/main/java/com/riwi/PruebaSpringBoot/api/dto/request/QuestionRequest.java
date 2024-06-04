package com.riwi.PruebaSpringBoot.api.dto.request;

import java.util.List;

import com.riwi.PruebaSpringBoot.util.enums.QuestionType;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequest {
    
    private Long id;

    @NotBlank(message = "Text must not be null")
    private String text;

    @NotBlank(message = "Type must not be null")
    private QuestionType type;

    private Long surveyId;

    private boolean active;

    private List<OptionRequest> options;
}
