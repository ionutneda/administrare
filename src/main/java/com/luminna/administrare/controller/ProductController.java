package com.luminna.administrare.controller;

import com.luminna.administrare.entity.Product;
import com.luminna.administrare.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // test
    @GetMapping("/")
    public String helloworld(){
        return "Welcome to my new site!";
    }

    // find all
    @GetMapping("/products")
    public List<Product>findAll(){
        return productService.findAll();
    }

    // find one
    @GetMapping("/products/{id}")
    public Product findById(@PathVariable Long Id){
        return productService.findById(Id);   //.orElseThrow(() -> new ProductNotFoundException(Id))    //concat
    }

    // post / save one
    @PostMapping("/products")
    public Product createOne(@RequestBody Product product){
        return productService.save(product);
    }

    // post all
    @PostMapping("/products/all")
    public List<Product> saveAll(@RequestBody List<Product> products){
        return productService.saveAll(products);
    }

}


