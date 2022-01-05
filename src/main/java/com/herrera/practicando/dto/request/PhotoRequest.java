package com.herrera.practicando.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Validated
public class PhotoRequest {
    @NotNull(message = "Photo can not be null")
    @NotBlank(message = "Photo can not be empty")
    private String photography;
    private String footer;
    private String paragraph;
}
