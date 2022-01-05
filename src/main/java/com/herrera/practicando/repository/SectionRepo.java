package com.herrera.practicando.repository;

import com.herrera.practicando.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SectionRepo extends JpaRepository<Section, Long> {
    Optional<Section> findByName(String name);
}
