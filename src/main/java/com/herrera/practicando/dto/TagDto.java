package com.herrera.practicando.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.herrera.practicando.dto.response.ReportResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagDto {

    private String name;
    private SectionDto section;
    @JsonIgnore
    private List<ReportResponse> reports;

}
