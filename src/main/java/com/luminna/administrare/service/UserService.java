package com.luminna.administrare.service;

import com.luminna.administrare.entity.Product;
import com.luminna.administrare.entity.User;
import com.luminna.administrare.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User save(User user) { return userRepository.save(user); }

    public List<User> saveAll(List<User> users){
        return userRepository.saveAll(users);
    }

    public User findById(Long Id){
        return userRepository.getById(Id);
    }


    public void delete(User user) {
        userRepository.deleteById(user.getId());
    }
}
