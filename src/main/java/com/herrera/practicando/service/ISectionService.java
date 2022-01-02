package com.herrera.practicando.service;

import com.herrera.practicando.dto.request.SectionRequest;
import com.herrera.practicando.dto.response.SectionResponse;

public interface ISectionService {
    public SectionResponse createSection(SectionRequest request);
}
