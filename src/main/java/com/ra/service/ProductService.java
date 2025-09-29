package com.ra.service;

import com.ra.model.dto.ProductRequestDTO;
import com.ra.model.dto.ProductResponseDTO;
import com.ra.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    ProductResponseDTO findById(int id);
    boolean create(ProductRequestDTO product);
    boolean update(ProductRequestDTO product, int id);
    boolean delete(int id);
    boolean isExistsProductNameCreate(String productName);
}
