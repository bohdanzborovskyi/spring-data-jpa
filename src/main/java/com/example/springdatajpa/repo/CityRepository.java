package com.example.springdatajpa.repo;

import com.example.springdatajpa.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}