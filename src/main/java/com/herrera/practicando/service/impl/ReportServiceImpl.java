package com.herrera.practicando.service.impl;

import com.herrera.practicando.dto.request.ReportRequest;
import com.herrera.practicando.dto.request.SectionRequest;
import com.herrera.practicando.dto.response.ReportResponse;
import com.herrera.practicando.dto.response.SectionResponse;
import com.herrera.practicando.exceptionhandler.exceptions.NotAvailableException;
import com.herrera.practicando.exceptionhandler.exceptions.NotFoundException;
import com.herrera.practicando.model.Report;
import com.herrera.practicando.model.Section;
import com.herrera.practicando.model.Tag;
import com.herrera.practicando.repository.ReportRepo;
import com.herrera.practicando.repository.SectionRepo;
import com.herrera.practicando.repository.TagRepo;
import com.herrera.practicando.repository.UserRepo;
import com.herrera.practicando.service.IReportService;
import com.herrera.practicando.utils.Thrower;
import com.herrera.practicando.utils.UserGetter;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Date;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements IReportService {

    private final UserRepo userRepo;
    private final ReportRepo reportRepo;
    private final SectionRepo sectionRepo;
    private final TagRepo tagRepo;
    private final ModelMapper mapper;

    @Override
    public ReportResponse createReport(ReportRequest request) {
        return null;
    }

    @Override
    @Transactional
    public ReportResponse createReportWithSectionAndTag(Long sectionId, Long tagId, ReportRequest request) {
        reportRepo.findByTitle(request.getTitle())
                .ifPresent(report -> Thrower.throwException(new NotAvailableException("Report with this title already exists", report.getTitle())));
        Section section = sectionRepo.findById(sectionId)
                .orElseThrow(() -> new NotFoundException("Section not found", sectionId.toString()));
        Tag tag = tagRepo.findById(tagId)
                .orElseThrow(() -> new NotFoundException("Tag not found", tagId.toString()));
        Report newReport = mapper.map(request, Report.class);
        newReport.setCreatedAt(Date.from(Instant.now()));
        newReport.setSection(section);
        newReport.setTag(tag);
        newReport.setCreator(userRepo.findByUsername(UserGetter.getUserFromContext()).orElseThrow());
        reportRepo.save(newReport);
        return mapper.map(newReport, ReportResponse.class);
    }

}
