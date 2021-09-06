package com.example.springdatajpa.repo;

import com.example.springdatajpa.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}