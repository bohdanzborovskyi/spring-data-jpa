package com.example.springdatajpa.repo;

import com.example.springdatajpa.model.Address;
import com.example.springdatajpa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long>
{

}