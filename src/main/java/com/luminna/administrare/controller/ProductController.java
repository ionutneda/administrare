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
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProviderService providerService;
    @Autowired
    private CategoryService categoryService;


    // Index page with a list of all the products with/without keyword (search).
    @GetMapping({"/", "/index", "/home"})
    public String getAllWithKeyword(Model model, @Param("keyword") String keyword) {
        model.addAttribute("title", "acasa");
        model.addAttribute("products", productService.findByKeyword(keyword));
        model.addAttribute("keyword", keyword);
        return "index";
    }

    // Index page with a list of all the products and a category filter todo - not working
    @GetMapping({"/{category}", "/index/{category}", "/home/{category}"})
    public String gettAllWithCategory(Model model,
                                      @Param("keyword") String keyword,
                                      @RequestParam("category") String category) {
        model.addAttribute("title", "acasa");
        model.addAttribute("products", productService.findAllWithCategory(category));
        model.addAttribute("keyword", keyword);
        model.addAttribute("category", category);
        return "index";
    }

    // Product details page (find one product, by id).
    @GetMapping("product/{id} ")
    public String showProductDetails(@PathVariable Long id, Model model) {
        model.addAttribute("title", "detalii produs");
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("provider", providerService.findAll());
        model.addAttribute("category", categoryService.findAll());
        return "product-details";
    }

    // Add product form page
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

    // Add / save the product from the add product form.
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

    // todo post a list of products / batch // reading from a CSV file

    // Method to delete product by id.
    @RequestMapping(value = "/product/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String delete(@PathVariable("id") long id){
        productService.delete(id);
        return "redirect:/";
    }

}


