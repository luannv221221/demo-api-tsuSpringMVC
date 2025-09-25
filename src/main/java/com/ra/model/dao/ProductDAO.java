package com.ra.model.dao;

import com.ra.model.entity.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();
    Product findById(int id);
    boolean save(Product product);
    boolean delete(int id);
    // check ton tai cua ten san pham khi them moi
    boolean isExistsProductNameCreate(String productName);

}
