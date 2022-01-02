package com.herrera.practicando.controller;

import com.herrera.practicando.service.IReportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/reports")
@AllArgsConstructor
public class ReportsController {

    private final IReportService reportsService;

}
