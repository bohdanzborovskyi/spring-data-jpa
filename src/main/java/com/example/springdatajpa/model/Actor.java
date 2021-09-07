package com.example.springdatajpa.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "actor")
@Entity
public class Actor
{
    @Id
    @Column(name = "actor_id", nullable = false)
    private Long actor_id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "last_update")
    private LocalDate last_update;

    @ManyToMany(mappedBy = "actors")
    private List<Film> films;

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public LocalDate getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDate last_update) {
        this.last_update = last_update;
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

    public Long getActor_id() {
        return actor_id;
    }

    public void setActor_id(Long actor_d) {
        this.actor_id = actor_d;
    }

    public Actor(Long actor_id, String first_name, String last_name, LocalDate last_update) {
        this.actor_id = actor_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.last_update = last_update;
    }

    public Actor() {
    }
}