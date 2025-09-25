package com.ra.model.entity;


import com.ra.model.enums.CategoryStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "category_name",length = 100,nullable = false,unique = true)
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
    @Column(name = "category_status")
    @Enumerated(EnumType.STRING)
    private CategoryStatus categoryStatus;

    public Category() {
    }

    public Category(int id, String categoryName, List<Product> products, CategoryStatus categoryStatus) {
        this.id = id;
        this.categoryName = categoryName;
        this.products = products;
        this.categoryStatus = categoryStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public CategoryStatus getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(CategoryStatus categoryStatus) {
        this.categoryStatus = categoryStatus;
    }
}