package com.freddy.training.controller;

import java.util.Map;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.freddy.training.model.Product;
import com.freddy.training.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/productsList")
    public String listProducts(Map<String, Object> map) {

        map.put("productsList", productService.getAllProducts());

        return "product/productsList";
    }

    @RequestMapping("/addProduct")
    public String addProduct(Map<String, Object> map) {

        map.put("product", new Product());

        return "product/addProduct";
    }

    @RequestMapping(value = "/addNewProduct", method = RequestMethod.POST)
    public String addNewProduct(@ModelAttribute("product")
    Product product, BindingResult result) {

        productService.addProduct(product);

        return "redirect:/productsList";
    }

    @RequestMapping("/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable("productId")
    Integer productId) {

        productService.removeProduct(productId);

        return "redirect:/productsList";
    }

}
