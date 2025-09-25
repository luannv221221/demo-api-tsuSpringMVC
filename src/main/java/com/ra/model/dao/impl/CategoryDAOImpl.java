package com.ra.model.dao.impl;

import com.ra.model.dao.CategoryDAO;
import com.ra.model.entity.Category;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class CategoryDAOImpl implements CategoryDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Category> getCategories() {
        return entityManager.createQuery("from Category", Category.class).getResultList();
    }
}
