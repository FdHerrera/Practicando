package com.herrera.practicando.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class ReportDto {
    private UserDto creator;
    private String title;
    private String subtitle;
    private String body;
    private SectionDto section;
    private TagDto tag;
    private Set<PhotoDto> photos;
}
