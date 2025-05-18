package com.app.TechHive.domain.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotBlank(message = "Technology is required")
    private String technology;
    @NotBlank(message = "Objective is required")
    private String objective;
    @NotBlank(message = "Language is required")
    private String language;

}
