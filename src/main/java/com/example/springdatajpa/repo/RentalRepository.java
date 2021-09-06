package com.example.springdatajpa.repo;

import com.example.springdatajpa.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}