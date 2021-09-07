package com.example.springdatajpa.service;

import com.example.springdatajpa.model.*;
import com.example.springdatajpa.repo.*;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
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


    public void initDB()
    {
        actorRepository.save(new Actor(0L,"Ivan","Bodrov", LocalDate.now()));
        actorRepository.save(new Actor(1L,"Jeremy","August", LocalDate.now()));

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

        customerRepository.save(new Customer(0L,"Erick","Double","erick.double@mail.com",true,LocalDate.now(),LocalDate.now(),false,addressRepository.getById(0L),rentalRepository.findById(0L).get()));
        customerRepository.save(new Customer(1L,"Timoti","Rynau","timoti.rynau@mail.com",true,LocalDate.now(),LocalDate.now(),false,addressRepository.getById(1L),rentalRepository.findById(1L).get()));

        languageRepository.save(new Language(0L,"english",LocalDate.now()));
        languageRepository.save(new Language(1L,"spanish",LocalDate.now()));

        filmRepository.save(new Film("Godzilla","Movie about monster from another world","2002"
                ,10,5.60,"1h27m",30.30,8.4,LocalDate.now(),"Classic movie",
                "The world is beset by the appearance of monstrous creatures, but one of them may be the only one who can save humanity.",
                Set.of(languageRepository.getById(0L)), List.of(actorRepository.findById(0L).get())));
        filmRepository.save(new Film("Home alone","Movie about child alone in home","1994"
                ,4,3.60,"1h44m",22.30,8.7,LocalDate.now(),"Classic movie",
                "An eight-year-old troublemaker must protect his house from a pair of " +
                        "burglars when he is accidentally left home alone by his family during Christmas vacation.",
                Set.of(languageRepository.getById(1L)), List.of(actorRepository.findById(1L).get())));

        inventoryRepository.save(new Inventory(0L,LocalDate.of(2021,8,10),rentalRepository.findById(0L).get(),filmRepository.findByTitle("Home alone")));
        inventoryRepository.save(new Inventory(1L,LocalDate.now(),rentalRepository.findById(1L).get(),filmRepository.findByTitle("Home alone")));

        Rental rentalOne = rentalRepository.findById(0L).get();
        rentalOne.setInventory(inventoryRepository.getById(0L));
        rentalOne.setCustomer(customerRepository.getById(0L));
        rentalRepository.save(rentalOne);

        Rental rentalTwo = rentalRepository.findById(1L).get();
        rentalTwo.setInventory(inventoryRepository.getById(1L));
        rentalTwo.setCustomer(customerRepository.getById(0L));
        rentalRepository.save(rentalTwo);

        storeRepository.save(new Store(0L));
        storeRepository.save(new Store(1L));

        System.out.println(storeRepository.getById(0L).getStore_id());

        staffRepository.save(new Staff(0L,"Josh","Gooli","josh.gooli@mail.com",true,"josh123","pass123",LocalDate.now(),addressRepository.getById(0L),storeRepository.getById(0L)));
        staffRepository.save(new Staff(1L,"Denis","Wealdz","denis.waldz@mail.com",false,"denis123","pass123",LocalDate.now(),addressRepository.getById(1L), storeRepository.getById(1L)));

        Store storeOne = storeRepository.getById(0L);
        storeOne.setStaff(staffRepository.getById(0L));
        storeRepository.save(storeOne);

        Store storeTwo = storeRepository.getById(1L);
        storeTwo.setStaff(staffRepository.getById(1L));
        storeRepository.save(storeTwo);

        paymentRepository.save(new Payment(22.5,LocalDate.now(),rentalRepository.findById(0L).get(),staffRepository.getById(0L),customerRepository.getById(0L)));
        paymentRepository.save(new Payment(11.6,LocalDate.now(),rentalRepository.findById(1L).get(),staffRepository.getById(0L),customerRepository.getById(0L)));
        paymentRepository.save(new Payment(18.2,LocalDate.now(),rentalRepository.findById(0L).get(),staffRepository.getById(1L),customerRepository.getById(1L)));

        Film film = filmRepository.findByTitle("Home alone");
        Category cat = categoryRepository.findByName("horror");
        film.addCategory(cat);
        filmRepository.save(film);

    }

}
