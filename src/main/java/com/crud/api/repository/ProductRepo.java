package com.crud.api.repository;

import com.crud.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    Product findByName(String name);
}
