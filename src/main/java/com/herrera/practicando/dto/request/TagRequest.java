package com.herrera.practicando.dto.request;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Validated
public class TagRequest {
    @NotNull(message = "Name can not be null")
    @NotBlank(message = "Name can not be empty")
    private String name;
}
