package com.example.springdatajpa.service;

import com.example.springdatajpa.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TestDB
{
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    FilmService filmService;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    StaffService staffService;

    @Autowired
    RentalService rentalService;

    public void testingDB()
    {
//        categoryRepository.findByOrderByNameAsc().forEach(c-> System.out.println(c.getName()));
//        filmRepository.findAllByCategoriesName("horror", PageRequest.of(0,20)).forEach(f-> System.out.println(f.getTitle()));
//        filmRepository.findAllByLanguagesName("spanish").forEach(f-> System.out.println(f.getTitle()));
//        actorRepository.findAllByFilmsTitle("Home alone").forEach(actor -> System.out.println(actor.getFirst_name() + " " + actor.getLast_name()));
//        System.out.println(filmService.getRentalStatusByFilmTitle("Home alone"));
//        paymentRepository.findAllByCustomer(customerRepository.getById(0L)).forEach(p -> System.out.println(p.getAmount()));
          customerService.getCustomerInfoAndAdress(0L);
//        staffService.getWholeStaffInfo();
//        filmService.findAllByActors("Ivan","Bodrov").forEach(f-> System.out.println("Title " + f.getTitle()));
//        rentalService.findAllRentalByCustomerID(0L);
    }

}
