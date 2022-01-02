package com.herrera.practicando.controller;

import com.herrera.practicando.dto.ReportRequest;
import com.herrera.practicando.dto.response.ReportResponse;
import com.herrera.practicando.service.IReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/reports")
@AllArgsConstructor
public class ReportsController {

    private final IReportService reportsService;

}
