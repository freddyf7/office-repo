package com.freddy.training.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.freddy.training.model.Product;
import com.freddy.training.service.ProductService;

@Component("productBean")
@Scope("request")
public class ProductBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private ProductService productService;

    private Product product;

    private List<Product> productList;

    private int productDelete;

    @PostConstruct
    public void init() {
        product = new Product();

        productList = productService.getAllProducts();
    }

    public void saveProduct(){
        Product newProduct = new Product();
        newProduct.setDescription(this.product.getDescription());
        newProduct.setName(this.product.getName());
        newProduct.setPrice(this.product.getPrice());
        newProduct.setType(this.product.getType());

        productService.addProduct(newProduct);
    }

    public void deleteProduct(){
        productService.removeProduct(this.product.getIdProduct());
        productList.remove(product);
    }

    public void updateProduct(){
        productService.updateProduct(product);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getProductDelete() {
        return productDelete;
    }

    public void setProductDelete(int productDelete) {
        this.productDelete = productDelete;
    }



}
