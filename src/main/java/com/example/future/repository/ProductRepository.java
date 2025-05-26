package com.example.future.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.future.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Tìm kiếm gần đúng theo tên (không phân biệt hoa thường)
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Product> searchByName(String name);
}