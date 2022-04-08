package com.luminna.administrare.repository;

import com.luminna.administrare.entity.Product;
import com.luminna.administrare.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
