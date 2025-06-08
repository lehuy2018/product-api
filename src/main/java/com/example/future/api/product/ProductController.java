package com.example.future.api.product;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.future.api.product.dto.ProductDTO;
import com.example.future.api.product.mapper.ProductMapper;
import com.example.future.domain.product.model.Product;
import com.example.future.domain.product.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final ProductService service;
	private final ProductMapper mapper;

	public ProductController(ProductService service, ProductMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}

	@GetMapping
	public ResponseEntity<List<Product>> getAll() {
		return ResponseEntity.ok(service.findAll());
	}

	@PostMapping
	public ResponseEntity<ProductDTO> create(@Valid @RequestBody ProductDTO dto) {
		Product product = service.save(mapper.toEntity(dto));
		return new ResponseEntity<>(mapper.toDto(product), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody ProductDTO product) {
		Product updated = service.update(id, mapper.toEntity(product));
		if (updated == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(mapper.toDto(updated));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		boolean deleted = service.delete(id);
		if (!deleted) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}

	@GetMapping("/search")
	public ResponseEntity<List<Product>> searchByName(@RequestParam String name) {
		return ResponseEntity.ok(service.searchProductByName(name));
	}

}