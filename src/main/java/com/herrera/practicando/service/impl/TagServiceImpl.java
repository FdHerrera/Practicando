package com.herrera.practicando.service.impl;

import com.herrera.practicando.dto.request.TagRequest;
import com.herrera.practicando.dto.response.TagResponse;
import com.herrera.practicando.exceptionhandler.exceptions.NotAvailableException;
import com.herrera.practicando.exceptionhandler.exceptions.NotFoundException;
import com.herrera.practicando.model.Section;
import com.herrera.practicando.model.Tag;
import com.herrera.practicando.repository.SectionRepo;
import com.herrera.practicando.repository.TagRepo;
import com.herrera.practicando.service.ITagService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.herrera.practicando.utils.Thrower.*;

@Service
@AllArgsConstructor
public class TagServiceImpl implements ITagService {

    private final SectionRepo sectionRepo;
    private final TagRepo tagRepo;
    private final ModelMapper mapper;

    @Override
    @Transactional
    public TagResponse createTagWithSection(Long sectionId, TagRequest request) {
        tagRepo.findByName(request.getName())
                .ifPresent(tag -> throwException(new NotAvailableException("A tag with this name is already created", tag.getName())));
        Section sectionFound = sectionRepo.findById(sectionId).orElseThrow(() -> new NotFoundException("Section not found", sectionId.toString()));
        Tag newTag = mapper.map(request, Tag.class);
        newTag.setSection(sectionFound);
        tagRepo.save(newTag);
        return mapper.map(newTag, TagResponse.class);
    }
}
