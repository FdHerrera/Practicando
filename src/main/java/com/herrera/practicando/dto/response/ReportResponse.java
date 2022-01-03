package com.herrera.practicando.dto.response;

import com.herrera.practicando.dto.PhotoDto;
import com.herrera.practicando.dto.SectionDto;
import com.herrera.practicando.dto.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class ReportResponse {
    private UserDto creator;
    private String title;
    private String subtitle;
    private String body;
    private SectionDto section;
    private TagResponse tag;
    private Set<PhotoDto> photos;
}
