package com.example.future.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.future.domain.product.model.Product;
import com.example.future.domain.product.repository.ProductRepository;

@Repository
public class JpaProductRepository implements ProductRepository {

	private final JpaProductJpa jpa;

	public JpaProductRepository(JpaProductJpa jpa) {
		this.jpa = jpa;
	}

	@Override
	public Product save(Product product) {
		return jpa.save(product);
	}

	@Override
	public Optional<Product> findById(Long id) {
		return jpa.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return jpa.existsById(id);
	}

	@Override
	public void deleteById(Long id) {
		jpa.deleteById(id);
	}

	@Override
	public List<Product> searchByName(String name) {
		return jpa.findByNameContainingIgnoreCase(name);
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return jpa.findAll(pageable);
	}
}
