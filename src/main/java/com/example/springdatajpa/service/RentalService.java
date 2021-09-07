package com.example.springdatajpa.service;

import com.example.springdatajpa.model.Customer;
import com.example.springdatajpa.model.Rental;
import com.example.springdatajpa.repo.CustomerRepository;
import com.example.springdatajpa.repo.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class RentalService
{

    @Autowired
    RentalRepository rentalRepository;

    @Autowired
    CustomerRepository customerRepository;

    public List<Rental> findAllRentalByCustomerID(Long id)
    {
        Pageable pageable = PageRequest.of(0,20);
        Customer customer = customerRepository.findById(id).get();
        rentalRepository.findAllByCustomer(customer,pageable).forEach(rental -> System.out.println(rental.getCustomer().getFirst_name()));
        List<Rental> rentals = rentalRepository.findAllByCustomer(customer,pageable);
        rentals.sort(Comparator.comparing(Rental::getRental_date).reversed());
        rentals.forEach(rental -> System.out.println(rental.getRental_date()));
        return rentals;
    }

}
