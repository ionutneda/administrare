package com.luminna.administrare.service;

import com.luminna.administrare.entity.Product;
import com.luminna.administrare.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Find all products
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // Find products by keyword or else find all.
    public List<Product> findByKeyword(String keyword) {
        if (keyword != null) {
            return productRepository.findByKeyword(keyword);
        }
        return productRepository.findAll();
    }

    // Find all products by category
    public List<Product> findAllWithCategory(String category) {
        return productRepository.findAll(Sort.by(category));
    }

    // Find products by keyword or else find all using ternary operator.
    public List<Product> search(String searchKey) {
        return searchKey == null ? productRepository.findAll() : productRepository.findByKeyword(searchKey);
    }

    // Save one product.
    public Product save(Product product) {
        return productRepository.save(product);
    }

    // ??? Save all the products from a list.
    public List<Product> saveAll(List<Product> products) {
        return productRepository.saveAll(products);
    }

    // Find one product by id.
    public Product findById(Long Id) {
        return productRepository.getById(Id);
    }

    // Update a product
//    public Optional<Product> update(Long id, Product newProduct) {
//        // Only update an item if it can be found first.
//        return productRepository.findById(id)
//                .map(oldItem -> {
//                    Product updated = oldItem.updateWith(newProduct);
//                    return productRepository.save(updated);
//                });
//    }

    // Delete one by id.
    public void delete(long id) {
        productRepository.deleteById(id);
    }
}
