package com.example.springdatajpa.repo;

import com.example.springdatajpa.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorRepository extends CrudRepository<Actor, Long>
{
    List<Actor> findAllByFilmsTitle(String title);

    @Query("select  a from Actor a where a.first_name=:first_name and a.last_name=:last_name")
    Actor findByFirstNameAndLastName(@Param("first_name") String first_name,@Param("last_name") String last_name);
}