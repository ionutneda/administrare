package com.luminna.administrare.controller;


import com.luminna.administrare.entity.Provider;
import com.luminna.administrare.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    // find all
    // find by id
    // save
    // edit
    // delete



}


