package com.example.springdatajpa.repo;

import com.example.springdatajpa.model.Actor;
import com.example.springdatajpa.model.Film;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface FilmRepository extends PagingAndSortingRepository<Film, Long>
{

    List<Film> findAllByCategoriesName(String category, Pageable pageRequest);
    List<Film> findAllByLanguagesName(String language);
    List<Film> findAllByActors(Actor actor);
    Film findByTitle(String title);

}