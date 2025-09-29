package com.ra.model.dto;

import com.ra.model.entity.Category;
import org.springframework.web.multipart.MultipartFile;

public class ProductResponseDTO {
    private String productName;
    private double productPrice;
    private Category category;
    private String description;
    private String urlImage;

    public ProductResponseDTO() {
    }

    public ProductResponseDTO(String productName, double productPrice, Category category, String description, String urlImage) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.category = category;
        this.description = description;
        this.urlImage = urlImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
