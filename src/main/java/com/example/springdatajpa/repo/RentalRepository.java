package com.example.springdatajpa.repo;

import com.example.springdatajpa.model.Customer;
import com.example.springdatajpa.model.Inventory;
import com.example.springdatajpa.model.Rental;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;

public interface RentalRepository extends PagingAndSortingRepository<Rental, Long>
{
    Rental findAllByInventory(Inventory inventory);
    List<Rental> findAllByCustomer(Customer customer, Pageable pageable);


}