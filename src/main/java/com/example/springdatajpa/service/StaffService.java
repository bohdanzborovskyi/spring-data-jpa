package com.example.springdatajpa.service;

import com.example.springdatajpa.repo.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StaffService
{
    @Autowired
    StaffRepository staffRepository;

    public void getWholeStaffInfo()
    {
        staffRepository.findAll().forEach(s ->
                        {
                            System.out.println("Name: " + s.getFirst_name() + " " +  s.getLast_name() +
                                    " email: " + s.getEmail() + " username: " + s.getUsername() +
                                    " store ID: " + s.getStore() + " is active: " + s.getActive() +
                                    " address: "  + s.getAddress().getAddress() + " " + s.getAddress().getAddress2() +
                                    " " + s.getAddress().getDistinct() + " " + s.getAddress().getPostal_code() +
                                    " " + s.getAddress().getCity().getCity() + s.getAddress().getCity().getCountry().getCountry() +
                                    " phone: " + s.getAddress().getPhone());

                        });
    }

}
