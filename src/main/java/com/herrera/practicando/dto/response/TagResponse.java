package com.herrera.practicando.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.herrera.practicando.dto.ReportDto;
import com.herrera.practicando.dto.SectionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class TagResponse {

    private String name;
    private SectionDto section;
    private List<ReportDto> reports;

}
