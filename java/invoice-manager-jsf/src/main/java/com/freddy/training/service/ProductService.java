package com.freddy.training.service;

import java.util.List;

import com.freddy.training.model.Product;

public interface ProductService {

    public void addProduct(Product product);

    public List<Product> getAllProducts();

    public Product getProduct(int idProduct);

    public void removeProduct(int idProduct);

    public void updateProduct(Product product);
}
