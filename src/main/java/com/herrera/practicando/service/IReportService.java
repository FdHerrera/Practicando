package com.herrera.practicando.service;

import com.herrera.practicando.dto.ReportRequest;
import com.herrera.practicando.dto.response.ReportResponse;

public interface IReportService {

    ReportResponse createReport(ReportRequest request);
    ReportResponse createReportWithSectionAndTag(Long sectionId, Long tagId, ReportRequest request);

}