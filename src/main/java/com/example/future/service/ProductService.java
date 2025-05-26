package com.example.future.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.future.entity.Product;
import com.example.future.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> findAll() {
        return repo.findAll();
    }

    public Product save(Product product) {
        return repo.save(product);
    }

    public Product findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Product update(Long id, Product newProduct) {
        return repo.findById(id).map(product -> {
            product.setName(newProduct.getName());
            product.setPrice(newProduct.getPrice());
            return repo.save(product);
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