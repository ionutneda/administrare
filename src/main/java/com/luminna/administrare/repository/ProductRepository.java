package com.luminna.administrare.repository;

import com.luminna.administrare.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE CONCAT " +
            "(p.code, ' '," +
            "p.name, ' '," +
            "p.category) LIKE %?1%")
    public List<Product> findByKeyword(String keyword);
}
