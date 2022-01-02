package com.herrera.practicando.dto.response;

import com.herrera.practicando.dto.ReportDto;
import lombok.Data;

import java.util.List;

@Data
public class SectionResponse {

    private String name;
    private List<ReportDto> reports;

}
