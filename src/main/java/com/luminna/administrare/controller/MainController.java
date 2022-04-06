package com.luminna.administrare.controller;

import com.luminna.administrare.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private ProductService productService;


    @GetMapping("/index")
    public String showHomePage(Model model){
        model.addAttribute("produse", productService.findAll());
        return "index";
    }

}


