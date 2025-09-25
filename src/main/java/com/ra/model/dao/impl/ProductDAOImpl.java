
package com.ra.model.dao.impl;

import com.ra.model.dao.ProductDAO;
import com.ra.model.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product findById(int id) {
        return entityManager.createQuery("from Product where id=:id", Product.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    @Transactional
    public boolean save(Product product) {
        try {
          entityManager.persist(product);
          return true;
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        try {
            Product product = entityManager.find(Product.class, id);
            entityManager.remove(product);
            return true;
        } catch (Exception e) {
          e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isExistsProductNameCreate(String productName) {
        try {
            entityManager.createQuery("from Product where productName=:productName")
                    .setParameter("productName", productName).getSingleResult();
            return true;
        } catch (NoResultException noResultException) {
           return false;
        }

    }


}
