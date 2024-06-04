package com.riwi.PruebaSpringBoot.api.dto.response;

import com.riwi.PruebaSpringBoot.util.enums.QuestionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponseInc {
    
    private Long id;

    private String text;

    private QuestionType type;

    private boolean active;
}
