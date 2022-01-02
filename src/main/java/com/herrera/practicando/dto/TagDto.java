package com.herrera.practicando.dto;

import lombok.Data;

import java.util.List;

@Data
public class TagDto {

    private String name;
    private SectionDto section;
    private List<ReportDto> reports;

}
