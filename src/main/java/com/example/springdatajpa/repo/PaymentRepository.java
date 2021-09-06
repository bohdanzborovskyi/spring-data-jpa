package com.example.springdatajpa.repo;

import com.example.springdatajpa.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}