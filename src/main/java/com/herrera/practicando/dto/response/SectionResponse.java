package com.herrera.practicando.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.herrera.practicando.dto.TagDto;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class SectionResponse {

    private String name;
    private List<TagDto> tags;
    private List<ReportResponse> reports;

}
