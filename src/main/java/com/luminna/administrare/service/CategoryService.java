package com.luminna.administrare.service;

import com.luminna.administrare.entity.Category;
import com.luminna.administrare.entity.Provider;
import com.luminna.administrare.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category save(Category category) {

        return categoryRepository.save(category);
    }

    public List<Category> saveAll(List<Category> categories){
        return categoryRepository.saveAll(categories);
    }

    public Category findById(Long Id){
        return categoryRepository.getById(Id);
    }


}
