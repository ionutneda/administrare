package com.luminna.administrare.controller;

import com.luminna.administrare.entity.Product;
import com.luminna.administrare.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    // implemented in the MainController
//    @GetMapping("/index")

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


    // add one product link
    @GetMapping("/adaugare-produs")
    public String addProductForm(Product product) {
        return "products/add-one";
    }

    // post / save one product method
    @PostMapping("/products/add-one")
    public String addOneProduct(@RequestBody @Valid Product product, BindingResult result, Model model){
        if (result.hasErrors()){
            return "products/add-one";
        }
        productService.save(product);
        return "redirect:/index";
    }


    // post all
    @PostMapping("/products/all")
    public List<Product> saveAll(@RequestBody List<Product> products){
        return productService.saveAll(products);
    }

}


