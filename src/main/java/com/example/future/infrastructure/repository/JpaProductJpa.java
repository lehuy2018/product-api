package com.example.future.infrastructure.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.future.domain.product.model.Product;

public interface JpaProductJpa extends JpaRepository<Product, Long> {
	List<Product> findByNameContainingIgnoreCase(String name);

	Page<Product> findAll(Pageable pageable);
}
