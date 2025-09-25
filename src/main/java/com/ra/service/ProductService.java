package com.ra.service;

import com.ra.model.entity.Product;
import org.springframework.validation.Errors;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
    boolean create(Product product);
    boolean update(Product product,int id);
    boolean delete(int id);
    boolean isExistsProductNameCreate(String productName);
}
