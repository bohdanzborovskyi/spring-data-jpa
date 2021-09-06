package com.example.springdatajpa.repo;

import com.example.springdatajpa.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}