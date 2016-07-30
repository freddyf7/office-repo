package com.freddy.training.dao;

import java.util.List;

import com.freddy.training.model.Product;

public interface ProductDAO {

    public void addProduct(Product product);

    public List<Product> getAllProducts();

    public void removeProduct(int idProduct);

    public Product getProduct(int idProduct);

    public void updateProduct(Product product);

}
