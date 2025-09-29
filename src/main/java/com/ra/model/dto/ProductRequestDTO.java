package com.ra.model.dto;

import com.ra.model.entity.Category;
import com.ra.validate.Unique;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;

public class ProductRequestDTO {

    @NotBlank(message = "Ten danh muc bat buoc phai nhap")
    @Unique(message = "Ten san pham da ton tai")
    private String productName;
    @Min(value = 1,message = "Gia san pham phai lon hon 0")
    private double productPrice;
    private Category category;
    private String description;
    private MultipartFile image;

    public ProductRequestDTO() {
    }

    public ProductRequestDTO(String productName, double productPrice, Category category, String description, MultipartFile image) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.category = category;
        this.description = description;
        this.image = image;
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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
