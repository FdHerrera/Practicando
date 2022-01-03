package com.herrera.practicando.service;

import com.herrera.practicando.dto.request.SectionRequest;
import com.herrera.practicando.dto.response.ReportResponse;
import com.herrera.practicando.dto.response.SectionResponse;

import java.util.List;

public interface ISectionService {
    List<ReportResponse> getReportsBySection(Long sectionId);

    public SectionResponse createSection(SectionRequest request);
}
