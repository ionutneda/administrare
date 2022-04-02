package com.luminna.administrare.repository;

import com.luminna.administrare.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {



//    public List<Product> findByProductCode(String productCode);
//    public List<Product> findByProductName(String productName);
//    public List<Product> findByProductCodeContaining(String code);
//    public List<Product> findByProductNameContaining(String name);
//    @Query("select p from Product p where p.ProductCode like %?1% or p.ProductName like %?1%")
//    public List<Product> findContaining(String product);

}
