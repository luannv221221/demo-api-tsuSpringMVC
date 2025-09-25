package com.ra.validate;

import com.ra.model.dao.ProductDAO;
import com.ra.model.entity.Category;
import com.ra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
public class UniqueValidateProductCreate implements ConstraintValidator<Unique,String> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(Unique unique) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            entityManager.createQuery("from Product where productName=:productName")
                    .setParameter("productName", s).getSingleResult();
            return false;
        } catch (Exception exception){
            exception.printStackTrace();
            return true;
        }

    }
}
