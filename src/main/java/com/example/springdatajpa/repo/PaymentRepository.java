package com.example.springdatajpa.repo;

import com.example.springdatajpa.model.Customer;
import com.example.springdatajpa.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long>
{
    List<Payment> findAllByCustomer(Customer customer);

}