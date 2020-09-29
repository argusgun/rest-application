package com.example.restapplication.repo;

import com.example.restapplication.entetities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
