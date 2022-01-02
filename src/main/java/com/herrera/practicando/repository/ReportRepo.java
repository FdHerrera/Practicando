package com.herrera.practicando.repository;

import com.herrera.practicando.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReportRepo extends JpaRepository<Report, Long> {
    Optional<Report> findByTitle(String title);
}
