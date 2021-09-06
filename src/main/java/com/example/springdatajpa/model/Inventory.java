package com.example.springdatajpa.model;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "inventory")
@Entity
public class Inventory
{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "inventory_id", nullable = false)
    private Long inventory_id;

    @Column(name = "last_update")
    private LocalDate last_update;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @OneToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToOne(optional = false)
    @JoinColumn(name = "rental_id", nullable = false)
    private Rental rental;

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public LocalDate getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDate last_update) {
        this.last_update = last_update;
    }

    public Long getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(Long inventory_id) {
        this.inventory_id = inventory_id;
    }

    public Inventory(LocalDate last_update, Rental rental) {
        this.rental = rental;
        this.last_update = last_update;
    }

    public Inventory() {
    }
}