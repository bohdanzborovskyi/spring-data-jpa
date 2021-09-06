package com.example.springdatajpa.repo;

import com.example.springdatajpa.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}