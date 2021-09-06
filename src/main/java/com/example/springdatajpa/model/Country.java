package com.example.springdatajpa.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "country")
@Entity
public class Country
{
    @Id
    @Column(name = "country_id", nullable = false)
    private Long country_id;

    @OneToMany()
    @JoinColumn(name = "country_country_id")
    private List<City> cities;

    @Column(name = "country")
    private String country;

    @Column(name = "last_update")
    private LocalDate last_update;

    public LocalDate getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDate last_update) {
        this.last_update = last_update;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public Long getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Long country_id) {
        this.country_id = country_id;
    }

    public Country(Long country_id, String country, LocalDate last_update) {
        this.country_id = country_id;
        this.country = country;
        this.last_update = last_update;
    }

    public Country() {
    }
}