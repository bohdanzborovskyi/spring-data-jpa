package com.example.springdatajpa.model;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "language")
@Entity
public class Language
{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "language_id", nullable = false)
    private Long language_id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_update")
    private LocalDate last_update;

    public LocalDate getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDate last_update) {
        this.last_update = last_update;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(Long language_id) {
        this.language_id = language_id;
    }


}