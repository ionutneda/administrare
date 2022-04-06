package com.luminna.administrare.repository;

import com.luminna.administrare.entity.Product;
import com.luminna.administrare.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



}
