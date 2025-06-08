package com.example.future.domain.product.repository;

import java.util.List;
import java.util.Optional;

import com.example.future.domain.product.model.Product;

public interface ProductRepository {

//    // Tìm kiếm gần đúng theo tên (không phân biệt hoa thường)
//    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
//    List<Product> searchByName(String name);

	List<Product> findAll();

	Product save(Product product);

	Optional<Product> findById(Long id);

	boolean existsById(Long id);

	void deleteById(Long id);

	List<Product> searchByName(String name);
}