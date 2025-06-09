package com.example.future.api.product;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
import com.example.future.domain.product.model.Product;
import com.example.future.domain.product.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<Page<ProductDTO>> getAll(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		Page<ProductDTO> result = service.getAllProducts(PageRequest.of(page, size));
		return ResponseEntity.ok(result);
	}

	@PostMapping
	public ResponseEntity<ProductDTO> create(@Valid @RequestBody ProductDTO dto) {
		return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody ProductDTO product) {
		ProductDTO updated = service.update(id, product);
		if (updated == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updated);
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
		List<Product> searchProductByName = service.searchProductByName(name);
		return ResponseEntity.ok(searchProductByName);
	}

}