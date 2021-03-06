package com.luminna.administrare.controller;

import com.luminna.administrare.entity.User;
import com.luminna.administrare.repository.UserRepository;
import com.luminna.administrare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    // inregistrare form
    @GetMapping("add")
    public String showSignUpForm(){
        return "user/add";
    }

    // add user method
    @PostMapping("/add")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {return "user/add";}
        userService.save(user);
        return "redirect:/index";
    }

    // view list of users
    @GetMapping("")
    public String showUserList(Model model){
        model.addAttribute("users", userService.findAll());
        return "user/list";
    }

    // update user view
    // is responsible for fetching the User entity that matches the supplied id from the database
    @GetMapping("/edit/{id}")
    public String showUpdateUserForm(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id)     // instead of userRepo should be userService, but wouldn't allow .orElseThrow method
                .orElseThrow(() -> new IllegalArgumentException("Id user invalid: "+ id));
        model.addAttribute("user", user);
        return "user/update";
    }

    // update method
    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user,
        BindingResult result, Model model) {
        if (result.hasErrors()){
            user.setId(id);
            return "user/update";
        }
        userService.save(user);
        return "redirect:/index";
    }

    // delete
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Id user invalid: " + id));
        userService.delete(user);
        return "redirect:/index";
    }



}


