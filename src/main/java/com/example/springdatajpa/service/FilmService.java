package com.example.springdatajpa.service;

import com.example.springdatajpa.model.Actor;
import com.example.springdatajpa.model.Film;
import com.example.springdatajpa.model.Inventory;
import com.example.springdatajpa.model.Rental;
import com.example.springdatajpa.repo.ActorRepository;
import com.example.springdatajpa.repo.FilmRepository;
import com.example.springdatajpa.repo.InventoryRepository;
import com.example.springdatajpa.repo.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class FilmService
{

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    RentalRepository rentalRepository;

    @Autowired
    ActorRepository actorRepository;

    public String getRentalStatusByFilmTitle(String title)
    {
        Film film = filmRepository.findByTitle(title);
        List<Inventory> inventories = inventoryRepository.findAllByFilm(film);
        inventories.sort(Comparator.comparing(Inventory::getLast_update));
        Inventory inventory = inventories.get(inventories.size()-1);
        Rental rental = rentalRepository.findAllByInventory(inventories.get(0));
        if(rental.getReturn_date().isBefore(LocalDate.now()))
            return "Film is available";
        else
            return "Film unavailable!";
    }

    public List<Film> findAllByActors(String firstname, String lastname)
    {
        Actor actor = actorRepository.findByFirstNameAndLastName(firstname,lastname);
        System.out.println(actor.getFirst_name());
        return filmRepository.findAllByActors(actor);
    }
}
