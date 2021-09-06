package com.example.springdatajpa.repo;

import com.example.springdatajpa.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}