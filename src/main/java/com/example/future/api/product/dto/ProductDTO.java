package com.example.future.api.product.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductDTO {

	private Long id;

	@NotBlank(message = "Name is required")
	private String name;

	@Min(value = 0, message = "Price must be greater than or equal to 0")
	private double price;

	// Getters + Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}