package com.herrera.practicando.service;

import com.herrera.practicando.dto.request.ReportRequest;
import com.herrera.practicando.dto.response.ReportResponse;

import java.util.List;

public interface IReportService {

    ReportResponse createReport(ReportRequest request);
    ReportResponse createReportWithSectionAndTag(Long sectionId, Long tagId, ReportRequest request);
    List<ReportResponse> getAllReports();
}