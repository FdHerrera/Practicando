package com.herrera.practicando.service.impl;

import com.herrera.practicando.dto.request.SectionRequest;
import com.herrera.practicando.dto.response.SectionResponse;
import com.herrera.practicando.exceptionhandler.exceptions.NotAvailableException;
import com.herrera.practicando.model.Section;
import com.herrera.practicando.repository.SectionRepo;
import com.herrera.practicando.service.ISectionService;
import com.herrera.practicando.utils.Thrower;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import static com.herrera.practicando.utils.Thrower.*;

@Service
@AllArgsConstructor
public class SectionServiceImpl implements ISectionService {

    private final SectionRepo sectionRepo;
    private final ModelMapper mapper;

    @Override
    public SectionResponse createSection(SectionRequest request) {
        sectionRepo.findByName(request.getName())
                .ifPresent(section -> throwException(new NotAvailableException("A section with this name is already created", section.getName())));
        Section newSection = mapper.map(request, Section.class);
        sectionRepo.save(newSection);
        return mapper.map(newSection, SectionResponse.class);
    }
}
