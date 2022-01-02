package com.herrera.practicando.dto;

import com.herrera.practicando.dto.request.PhotoRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@AllArgsConstructor
@Validated
public class ReportRequest {
    @NotNull(message = "Title can not be null")
    @NotBlank(message = "Title can not be empty")
    private String title;
    @NotNull(message = "Subtitle can not be null")
    @NotBlank(message = "Subtitle can not be empty")
    private String subtitle;
    @NotNull(message = "Photo can not be null")
    @NotBlank(message = "Photo can not be empty")
    private String body;
    @Valid
    @Size(max = 3)
    private Set<PhotoRequest> photos;
}