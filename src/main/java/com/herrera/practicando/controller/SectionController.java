package com.herrera.practicando.controller;

import com.herrera.practicando.dto.request.ReportRequest;
import com.herrera.practicando.dto.request.SectionRequest;
import com.herrera.practicando.dto.request.TagRequest;
import com.herrera.practicando.dto.response.ReportResponse;
import com.herrera.practicando.dto.response.SectionResponse;
import com.herrera.practicando.dto.response.TagResponse;
import com.herrera.practicando.service.IReportService;
import com.herrera.practicando.service.ISectionService;
import com.herrera.practicando.service.ITagService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/sections")
@AllArgsConstructor
public class SectionController {

    private final IReportService reportService;
    private final ISectionService sectionService;
    private final ITagService tagService;

    @PostMapping
    public ResponseEntity<SectionResponse> createSection(@RequestBody @Valid SectionRequest request){
        SectionResponse response = sectionService.createSection(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping(path = "/{sectionId}")
    public ResponseEntity<TagResponse> createTagInSection(@PathVariable("sectionId") Long sectionId,
                                                          @RequestBody TagRequest request){
        TagResponse response = tagService.createTagWithSection(sectionId, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping(path = "/{sectionId}/{tagId}")
    public ResponseEntity<ReportResponse> createReportInSectionWithTag(@PathVariable("sectionId") Long sectionId,
                                                                       @PathVariable("tagId") Long tagId,
                                                                       @RequestBody @Valid ReportRequest request){
        ReportResponse response = reportService.createReportWithSectionAndTag(sectionId, tagId, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
