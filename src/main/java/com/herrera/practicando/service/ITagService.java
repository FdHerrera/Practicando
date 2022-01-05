package com.herrera.practicando.service;

import com.herrera.practicando.dto.request.TagRequest;
import com.herrera.practicando.dto.response.TagResponse;

public interface ITagService {
    TagResponse createTagWithSection(Long sectionId, TagRequest request);
}
