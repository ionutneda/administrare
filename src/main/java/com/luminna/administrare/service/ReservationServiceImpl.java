package com.luminna.administrare.service;

import com.luminna.administrare.entity.Product;
import com.luminna.administrare.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    ReservationRepository reservationRepository;

    private Map<Product, Integer> reservation = new LinkedHashMap<>();

    @Override
    public void addProduct(Product product) {
        if (reservation.containsKey(product)){
            reservation.replace(product, reservation.get(product) -1);
        } else {
            reservation.put(product, 1);
        }
    }

    @Override
    public void removeProduct(Product product) {
        if (reservation.containsKey(product)) {
            if (reservation.get(product) > 1)
                reservation.replace(product, reservation.get(product) -1);
            else if (reservation.get(product) == 1) {
                reservation.remove(product);
            }
        }
    }

    @Override
    public void clearProducts() {
        reservation.clear();
    }

    @Override
    public Map<Product, Integer> productsInReservation() {
        return Collections.unmodifiableMap(reservation);
    }

    @Override
    public BigDecimal totalPrice() {
        return reservation.entrySet().stream()
                .map(k -> k.getKey().getPrice().multiply(BigDecimal.valueOf(k.getValue()))).sorted()
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }




}
