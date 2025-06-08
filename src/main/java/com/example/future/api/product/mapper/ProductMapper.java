package com.example.future.api.product.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.future.api.product.dto.ProductDTO;
import com.example.future.domain.product.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
//	For normal mapper class
//	public static ProductDTO toDTO(Product product) {
//		ProductDTO dto = new ProductDTO();
//		dto.setId(product.getId());
//		dto.setName(product.getName());
//		dto.setPrice(product.getPrice());
//		return dto;
//	}
//
//	public static Product toEntity(ProductDTO dto) {
//		Product product = new Product();
//		product.setId(dto.getId());
//		product.setName(dto.getName());
//		product.setPrice(dto.getPrice());
//		return product;
//	}

	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

	ProductDTO toDto(Product product);

	Product toEntity(ProductDTO dto);

	List<ProductDTO> toDtoList(List<Product> products);
}