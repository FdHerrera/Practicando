package com.herrera.practicando.service;

import com.herrera.practicando.dto.ReportRequest;
import com.herrera.practicando.dto.response.ReportResponse;

public interface IReportsService {

    ReportResponse createReport(ReportRequest request);

}