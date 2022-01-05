package com.herrera.practicando.controller;

import com.herrera.practicando.dto.response.ReportResponse;
import com.herrera.practicando.service.IReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/reports")
@AllArgsConstructor
public class ReportsController {

    private final IReportService reportsService;

    @GetMapping
    public ResponseEntity<List<ReportResponse>> getAllReports(){
        List<ReportResponse> response = reportsService.getAllReports();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
