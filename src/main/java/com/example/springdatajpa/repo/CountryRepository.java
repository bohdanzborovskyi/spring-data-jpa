package com.example.springdatajpa.repo;

import com.example.springdatajpa.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}