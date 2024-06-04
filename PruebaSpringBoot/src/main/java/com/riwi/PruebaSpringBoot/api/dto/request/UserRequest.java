package com.riwi.PruebaSpringBoot.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    
    @NotBlank(message = "Name must not be null")
    @Size(max = 100,message = "Name must no be more than 100 characters")
    private String name;

    @NotBlank(message = "Email must not be null")
    @Size(max = 100,message = "Email must no be more than 100 characters")
    private String email;

    @NotBlank(message = "Password must not be null")
    private String password;
    
    @NotBlank(message = "Status must not be null")
    private boolean active;
}
