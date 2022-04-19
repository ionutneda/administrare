package com.luminna.administrare.batch;

import com.luminna.administrare.entity.Product;
import com.luminna.administrare.repository.ProductRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<Product> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void write(List<? extends Product> products) throws Exception {

        System.out.println("Data saved for Products: " + products);
        productRepository.save((Product) products);
    }
}
