package com.riwi.PruebaSpringBoot.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OptionRequest {

    @NotBlank(message = "Text must not be null")
    private String text;

    @NotNull(message = "QuestionId must not be null")
    private Long questionId;

    private boolean active;
}
