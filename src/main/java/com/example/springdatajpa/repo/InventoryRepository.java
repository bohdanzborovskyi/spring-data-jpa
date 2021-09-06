package com.example.springdatajpa.repo;

import com.example.springdatajpa.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}