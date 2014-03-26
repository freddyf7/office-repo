package com.freddy.training.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.freddy.training.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addProduct(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return sessionFactory.getCurrentSession().createQuery("from Product").list();
    }

    @Override
    public void removeProduct(int idProduct) {
        Product product = (Product) sessionFactory.getCurrentSession().load(Product.class, idProduct);
        if (product != null) {
            sessionFactory.getCurrentSession().delete(product);
        }
    }

    @Override
    public Product getProduct(int idProduct) {
        Product product = (Product) sessionFactory.getCurrentSession().load(Product.class, idProduct);

        return product;
    }
}
