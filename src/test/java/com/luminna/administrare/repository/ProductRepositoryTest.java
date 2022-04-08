package com.luminna.administrare.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@DataJpaTest   // used to flush the data after the test so that the db won't be impacted
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;


//    @Test
//    public void saveProviderAndProduct(){
//
//        Provider provider = new Provider("Nova Luce", 30.00, 3, "Greece");
//
//        Provider provider2 = new Provider("Ideal Lux", 35.00, 3, "Italy");
//
//        Product product = new Product("62004","Technical", 74.00, "EUR", provider);
//        productRepository.save(product);
//
//        Product product2 = new Product("62002","Technical2", 74.00, "EUR", provider2);
//        productRepository.save(product2);
//
//        Provider provider4 = new Provider("Redo", 40.00, 1, "Romania");
//
//        Product product4 = new Product("01-1782","Orbit", 232.00, "EUR", provider4);
//        productRepository.save(product4);
//
//        System.out.println("Providers: " + provider + "\n" + provider2 +"\n"+ provider4);
//        System.out.println("Products: " + product + "\n" + product2 +"\n"+ product4);
//    }







}