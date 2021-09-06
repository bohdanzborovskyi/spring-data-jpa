package com.example.springdatajpa.model;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "city")
@Entity
public class City
{
    @Id
    @Column(name = "city_id", nullable = false)
    private Long city_id;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "city")
    private String city;

    @Column(name = "last_update")
    private LocalDate last_update;

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public LocalDate getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDate last_update) {
        this.last_update = last_update;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getCity_id() {
        return city_id;
    }

    public void setCity_id(Long city_id) {
        this.city_id = city_id;
    }
}