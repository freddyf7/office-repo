package com.freddy.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.freddy.training.dao.ProductDAO;
import com.freddy.training.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDao;

    @Transactional
    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Transactional
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Transactional
    public Product getProduct(int idProduct) {
        return productDao.getProduct(idProduct);
    }

    @Transactional
    public void removeProduct(int idProduct) {
        productDao.removeProduct(idProduct);
    }

    @Transactional
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }


}
