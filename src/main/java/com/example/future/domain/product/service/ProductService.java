package com.example.future.domain.product.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.future.api.product.dto.ProductDTO;
import com.example.future.api.product.mapper.ProductMapper;
import com.example.future.domain.product.model.Product;
import com.example.future.domain.product.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository repo;
	private final ProductMapper mapper;

	public ProductService(ProductRepository repo, ProductMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}

	public Page<ProductDTO> getAllProducts(Pageable pageable) {
		return repo.findAll(pageable).map(mapper::toDto);
	}

	public ProductDTO save(ProductDTO dto) {
		Product entity = repo.save(mapper.toEntity(dto));
		return mapper.toDto(entity);
	}

	public ProductDTO findById(Long id) {
		return repo.findById(id).map(mapper::toDto).orElse(null);
	}

	public ProductDTO update(Long id, ProductDTO newProduct) {
		return repo.findById(id).map(product -> {
			product.setName(newProduct.getName());
			product.setPrice(newProduct.getPrice());
			return mapper.toDto(repo.save(product));
		}).orElse(null);
	}

	public boolean delete(Long id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Product> searchProductByName(String name) {
		return repo.searchByName(name);
	}

}