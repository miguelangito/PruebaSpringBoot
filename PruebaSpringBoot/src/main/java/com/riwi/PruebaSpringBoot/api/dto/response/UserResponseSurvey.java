package com.riwi.PruebaSpringBoot.api.dto.response;

import java.util.List;

import com.riwi.PruebaSpringBoot.domain.entities.Survey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseSurvey {
    
    private Long id;
    private String name;
    private String email;
    private boolean active;
    private List<Survey> survey;
}
