package com.example.future;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.future.entity.Product;
import com.example.future.repository.ProductRepository;

@SpringBootTest
class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testInsertProduct() {
        // Tạo mới sản phẩm
        Product product = Product.builder().name("Test Product").price(999.0).quantity(20).build();

        // Lưu vào DB
        Product saved = productRepository.save(product);

        // Kiểm tra kết quả
        assertThat(saved.getId()).isNotNull();

        // Kiểm tra lại từ DB
        Optional<Product> fromDb = productRepository.findById(saved.getId());
        assertThat(fromDb).isPresent();
        assertThat(fromDb.get().getName()).isEqualTo("Test Product");
    }
}
