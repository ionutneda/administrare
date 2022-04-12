package com.luminna.administrare.service;

import com.luminna.administrare.entity.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public interface ReservationService {
    void addProduct(Product product);
    void removeProduct(Product product);
    void clearProducts();
    Map<Product, Integer> productsInReservation();
    BigDecimal totalPrice();
}
