package com.example.springdatajpa.repo;

import com.example.springdatajpa.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}