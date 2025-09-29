package com.ra.service.impl;

import com.ra.model.dao.ProductDAO;
import com.ra.model.dto.ProductRequestDTO;
import com.ra.model.dto.ProductResponseDTO;
import com.ra.model.entity.Product;
import com.ra.service.ProductService;
import com.ra.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private UploadFileService uploadFileService;
    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public ProductResponseDTO findById(int id) {
        Product product = productDAO.findById(id);
        // convent entity = > DTO
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setProductName(product.getProductName());
        productResponseDTO.setProductPrice(product.getProductPrice());
        productResponseDTO.setCategory(product.getCategory());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setUrlImage(product.getImage());
        return productResponseDTO;
    }

    @Override
    public boolean create(ProductRequestDTO product) {
        // xu ly upload file
        String imgPath = uploadFileService.uploadFile(product.getImage());
        // convert dto - > entity
        Product productnew = new Product();
        productnew.setProductName(product.getProductName());
        productnew.setCategory(product.getCategory());
        productnew.setProductPrice(product.getProductPrice());
        productnew.setDescription(product.getDescription());
        productnew.setImage(imgPath);
        return productDAO.save(productnew);
    }

    @Override
    public boolean update(ProductRequestDTO product, int id) {
        Product pro = productDAO.findById(id);
        if(pro==null){
            return false;
        }
        // convert DTO -> Entity
        Product productnew = new Product();
        productnew.setId(id);
        productnew.setProductName(product.getProductName());
        productnew.setCategory(product.getCategory());
        productnew.setProductPrice(product.getProductPrice());
        productnew.setDescription(product.getDescription());
        // xu ly upload file 
        String imgPath = uploadFileService.uploadFile(product.getImage());
        if(!Objects.equals(imgPath, "")){
            productnew.setImage(imgPath);
        } else {
            productnew.setImage(pro.getImage());
        }
        return productDAO.save(productnew);
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
