package com.example.springdatajpa.service;

import com.example.springdatajpa.model.*;
import com.example.springdatajpa.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Set;

@Service
public class InitDB
{

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    RentalRepository rentalRepository;

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    StoreRepository storeRepository;

    @PostConstruct
    public void initDB()
    {
        actorRepository.save(new Actor("Ivan","Bodrov", LocalDate.now()));
        actorRepository.save(new Actor("Jeremy","August", LocalDate.now()));

        countryRepository.save(new Country(0L,"Polish", LocalDate.now()));
        countryRepository.save(new Country(1L,"England", LocalDate.now()));
        countryRepository.save(new Country(2L,"Turkey", LocalDate.now()));

        cityRepository.save(new City(0L,"Sosnowiec",LocalDate.now(),countryRepository.getById(0L)));
        cityRepository.save(new City(1L,"Hamsheere",LocalDate.now(),countryRepository.getById(1L)));
        cityRepository.save(new City(2L,"Ludo",LocalDate.now(),countryRepository.getById(2L)));

        addressRepository.save(new Address(0L,"Polish","Sosnowiec, ul.Rybak 18","Silesian","41-200","880-090-098",LocalDate.now(),cityRepository.getById(0L)));
        addressRepository.save(new Address(1L,"England","Rostberry, Backon street 23/2","Hampsheere","321-125","999-090-098",LocalDate.now(),cityRepository.getById(1L)));

        categoryRepository.save(new Category("horror",LocalDate.now()));
        categoryRepository.save(new Category("drama",LocalDate.now()));
        categoryRepository.save(new Category("adventure",LocalDate.now()));

        rentalRepository.save(new Rental(0L,LocalDate.of(2021,9,5),LocalDate.of(2021,9,14),
                LocalDate.now()));
        rentalRepository.save(new Rental(1L,LocalDate.of(2021,9,1),LocalDate.of(2021,9,10),
                LocalDate.now()));

        customerRepository.save(new Customer("Erick","Double","erick.double@mail.com",true,LocalDate.now(),LocalDate.now(),false,addressRepository.getById(0L),rentalRepository.getById(0L)));
        customerRepository.save(new Customer("Timoti","Rynau","timoti.rynau@mail.com",true,LocalDate.now(),LocalDate.now(),false,addressRepository.getById(1L),rentalRepository.getById(1L)));

        languageRepository.save(new Language(0L,"english",LocalDate.now()));
        languageRepository.save(new Language(1L,"sspanish",LocalDate.now()));

        filmRepository.save(new Film("Godzilla","Movie about monster from another world","2002"
                ,10,5.60,"1h27m",30.30,8.4,LocalDate.now(),"Classic movie",
                "The world is beset by the appearance of monstrous creatures, but one of them may be the only one who can save humanity.", Set.of(languageRepository.getById(0L))));
        filmRepository.save(new Film("Home alone","Movie about child alone in home","1994"
                ,4,3.60,"1h44m",22.30,8.7,LocalDate.now(),"Classic movie",
                "An eight-year-old troublemaker must protect his house from a pair of " +
                        "burglars when he is accidentally left home alone by his family during Christmas vacation.",Set.of(languageRepository.getById(1L))));

        inventoryRepository.save(new Inventory(LocalDate.now(),rentalRepository.getById(0L)));
        inventoryRepository.save(new Inventory(LocalDate.now(),rentalRepository.getById(1L)));

        staffRepository.save(new Staff(0L,"Josh","Gooli","josh.gooli@mail.com",true,"josh123","pass123",LocalDate.now()));
        staffRepository.save(new Staff(1L,"Denis","Wealdz","denis.waldz@mail.com",false,"denis123","pass123",LocalDate.now()));

        paymentRepository.save(new Payment(22.5,LocalDate.now(),rentalRepository.getById(0L),staffRepository.getById(0L)));
        paymentRepository.save(new Payment(11.6,LocalDate.now(),rentalRepository.getById(1L),staffRepository.getById(0L)));
        paymentRepository.save(new Payment(18.2,LocalDate.now(),rentalRepository.getById(0L),staffRepository.getById(1L)));

        storeRepository.save(new Store(staffRepository.getById(0L)));
        storeRepository.save(new Store(staffRepository.getById(1L)));

    }

}
