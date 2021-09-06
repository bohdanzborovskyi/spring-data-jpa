package com.example.springdatajpa.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "rental")
@Entity
public class Rental
{
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "rental_id", nullable = false)
    private Long rental_id;

    @Column(name = "rental_date")
    private LocalDate rental_date;

    @OneToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "return_date")
    private LocalDate return_date;

    @Column(name = "last_update")
    private LocalDate last_update;

    @OneToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @OneToMany
    @JoinColumn(name = "rental_id")
    private List<Payment> payments;

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public LocalDate getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDate last_update) {
        this.last_update = last_update;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public LocalDate getRental_date() {
        return rental_date;
    }

    public void setRental_date(LocalDate rental_date) {
        this.rental_date = rental_date;
    }

    public Long getRental_id() {
        return rental_id;
    }

    public void setRental_id(Long rental_id) {
        this.rental_id = rental_id;
    }

    public Rental(Long rental_id, LocalDate rental_date, LocalDate return_date, LocalDate last_update) {
        this.rental_id = rental_id;
        this.rental_date = rental_date;
        this.return_date = return_date;
        this.last_update = last_update;
    }

    public Rental() {
    }
}