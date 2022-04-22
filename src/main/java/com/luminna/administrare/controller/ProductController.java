package com.luminna.administrare.controller;

import com.luminna.administrare.entity.Category;
import com.luminna.administrare.entity.Product;
import com.luminna.administrare.entity.Provider;
import com.luminna.administrare.service.CategoryService;
import com.luminna.administrare.service.ProductService;
import com.luminna.administrare.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProviderService providerService;
    @Autowired
    private CategoryService categoryService;



    // Index page with a list of all the products with/without keyword (search).
    @GetMapping({"/product"})
    public String getAllWithKeyword(Model model, @Param("keyword") String keyword) {
        model.addAttribute("title", "Produse");
        model.addAttribute("products", productService.findByKeyword(keyword));
        model.addAttribute("keyword", keyword);
        return "/product/index";
    }

    // Index page with a list of all the products and a category filter todo - not


    // Product details page (find one product, by id).
    @GetMapping("/product/{id}")
    public String showProductDetails(@PathVariable("id") long id, Model model) {
        model.addAttribute("title", "Detalii produs");
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("provider", providerService.findAll());
        model.addAttribute("category", categoryService.findAll());
        return "/product/product-details";
    }

    // Add product form page
    @GetMapping("/product/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("title", "Adaugare produs");
        Product product = new Product();
        model.addAttribute("product", product);
        // providers and categories are used to populate the dropdown options
        model.addAttribute("providers", providerService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "/product/add";
    }

    // Add / save the product within the add product form.
    @PostMapping("/product/add")
    public String processAddProductForm(@Valid Product product,
                                        BindingResult result,
                                        Model model,
                                        @RequestParam Long categoryId,
                                        @RequestParam Long providerId) {
//        if (result.hasErrors()) {
//            return "redirect:/product/add";
//        }
        model.addAttribute("title", "Detalii produs");
        Provider provider = providerService.findById(providerId);
        product.setProvider(provider);
        Category category = categoryService.findById(categoryId);
        product.setCategory(category);
        productService.save(product);
        return "/product/added-product-details";
    }

    // todo post a list of products / batch // reading from a CSV file

    // Method to delete product by id.
    @RequestMapping(value = "/product/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(@PathVariable("id") long id) {
        productService.delete(id);
        return "redirect:/product";
    }

    // Update
    @RequestMapping(value = "/product/update/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
    public String update(@Valid Product product,
                         Model model,
                         @RequestParam Long categoryId,
                         @RequestParam Long providerId) {
        model.addAttribute("title", "Modificare produs");
        Provider provider = providerService.findById(providerId);
        product.setProvider(provider);
        Category category = categoryService.findById(categoryId);
        product.setCategory(category);
        productService.save(product);
        return "/product/added-product-details";
    }


}


