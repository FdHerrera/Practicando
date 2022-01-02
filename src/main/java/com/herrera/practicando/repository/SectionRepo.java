package com.herrera.practicando.repository;

import com.herrera.practicando.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepo extends JpaRepository<Section, Long> {
}
