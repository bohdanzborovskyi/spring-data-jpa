package com.example.springdatajpa.repo;

import com.example.springdatajpa.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}