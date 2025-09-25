package com.ra.model.entity;

import com.ra.validate.Unique;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "product_name",length = 100,nullable = false,unique = true)
    @NotBlank(message = "Ten danh muc bat buoc phai nhap")
    @Unique(message = "Ten san pham da ton tai")
    private String productName;
    @Column(name = "product_price",columnDefinition = "double check(product_price >0)",nullable = false)
    @Min(value = 1,message = "Gia san pham phai lon hon 0")
    private double productPrice;
    @Column(name = "description",columnDefinition = "text")
    private String description;
    @Column(name = "image",length = 255)
    private String image;
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    public Product() {
    }

    public Product(int id, String productName, double productPrice, String description, String image, Category category) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.description = description;
        this.image = image;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}