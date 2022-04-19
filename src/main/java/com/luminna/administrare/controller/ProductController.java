package com.luminna.administrare.controller;

import com.luminna.administrare.entity.Category;
import com.luminna.administrare.entity.Product;
import com.luminna.administrare.entity.Provider;
import com.luminna.administrare.service.CategoryService;
import com.luminna.administrare.service.ProductService;
import com.luminna.administrare.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProviderService providerService;
    @Autowired
    private CategoryService categoryService;


    // search items by id from the home page
    @GetMapping({"/", "/index", "/home"})
    public String showProducts(Model model) {
        model.addAttribute("title", "acasa");
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    // read one (product details page)
    @GetMapping("product/{id} ")
    public String showProductDetails(@PathVariable Long id, Model model) {
        model.addAttribute("title", "detalii produs");
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("provider", providerService.findAll());
        model.addAttribute("category", categoryService.findAll());
        return "product-details";
    }


    // add one product link ***
    @GetMapping("product/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("title", "adaugare produs");
        Product product = new Product();
        model.addAttribute("product", product);
        // providers and categories are used to populate the dropdown options
        model.addAttribute("providers", providerService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "product/add";
    }


    // post / save one product method
    @PostMapping("product/add")
    public String processAddProductForm(@Valid Product product,
                                        BindingResult result,
                                        Model model,
                                        @RequestParam Long categoryId,
                                        @RequestParam Long providerId) {
//        if (result.hasErrors()) {
//            return "redirect:/product/add";
//        }
        Provider provider = providerService.findById(providerId);
        product.setProvider(provider);
        Category category = categoryService.findById(categoryId);
        product.setCategory(category);
        productService.save(product);
        return "product/product-details"; // todo - I want to return the product page
    }


    // post a list of products / batch // reading from a CSV file


}


