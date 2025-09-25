package com.ra.service.impl;

import com.ra.model.dao.ProductDAO;
import com.ra.model.entity.Product;
import com.ra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;
    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public boolean create(Product product) {

        return productDAO.save(product);
    }

    @Override
    public boolean update(Product product, int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return productDAO.delete(id);
    }

    @Override
    public boolean isExistsProductNameCreate(String productName) {
        return productDAO.isExistsProductNameCreate(productName);
    }
}
