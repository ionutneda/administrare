package com.luminna.administrare.controller;

import com.luminna.administrare.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {

    @Autowired
    private ProductService productService;


    @GetMapping({"/", "/index", "/home"})
    public String showIndex(Model model) {
        model.addAttribute("title", "Acasa");
        return "index";
    }

}


