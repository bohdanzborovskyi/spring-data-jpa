package com.example.springdatajpa.model;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Table(name = "staff")
@Entity
public class Staff
{

    @Id
    @Column(name = "staff_id", nullable = false)
    private Long staff_id;

    @OneToOne()
    @JoinColumn(name = "rental_id")
    private Rental rental;

    @OneToMany()
    @JoinColumn(name = "staff_staff_id")
    private List<Payment> payments;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(name = "active")
    private boolean active;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "last_update")
    private LocalDate last_update;

    @Lob
    @Column(name = "picture")
    private Blob picture;

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public LocalDate getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDate last_update) {
        this.last_update = last_update;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String emial) {
        this.email = emial;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public Long getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Long staff_id) {
        this.staff_id = staff_id;
    }

    public Staff(Long staff_id, String first_name, String last_name, String emial,
                 boolean active, String username, String password, LocalDate last_update,
                 Address address, Store store) {
        this.staff_id = staff_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = emial;
        this.active = active;
        this.username = username;
        this.password = password;
        this.last_update = last_update;
        this.address = address;
        this.store = store;
    }

    public Staff() {
    }
}