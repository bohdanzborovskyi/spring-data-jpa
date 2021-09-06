package com.example.springdatajpa.repo;

import com.example.springdatajpa.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long>
{
    List<Category> findAllAndSortOrderByName();
}