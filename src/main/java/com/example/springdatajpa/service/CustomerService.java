package com.example.springdatajpa.service;

import com.example.springdatajpa.model.Address;
import com.example.springdatajpa.model.Customer;
import com.example.springdatajpa.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService
{
    @Autowired
    CustomerRepository customerRepository;

    public Address getCustomerInfoAndAdress(Long id)
    {
        Customer customer = customerRepository.getById(id);
        System.out.println("Name: " + customer.getFirst_name() + " " + customer.getLast_name() +
                " email:  " +  customer.getEmail() +
                " address: " + customer.getAddress().getAddress() + " " + customer.getAddress().getAddress2() +
                " " + customer.getAddress().getDistinct() + " " + customer.getAddress().getPostal_code() +
                " " + customer.getAddress().getCity().getCity() + customer.getAddress().getCity().getCountry().getCountry() +
                " phone: " + customer.getAddress().getPhone());
        return customer.getAddress();
    }

}
