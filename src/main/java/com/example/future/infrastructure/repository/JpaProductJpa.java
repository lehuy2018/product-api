package com.example.future.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.future.domain.product.model.Product;

@Repository
public interface JpaProductJpa extends JpaRepository<Product, Long> {
	List<Product> findByNameContainingIgnoreCase(String name);
}
