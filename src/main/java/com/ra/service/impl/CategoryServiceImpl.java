package com.ra.service.impl;

import com.ra.model.dao.CategoryDAO;
import com.ra.model.entity.Category;
import com.ra.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;
    @Override
    public List<Category> getAllCategories() {
        return categoryDAO.getCategories();
    }
}
