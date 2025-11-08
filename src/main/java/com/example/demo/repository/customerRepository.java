package com.example.demo.repository;

import com.example.demo.entitas.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
// Interface
public interface customerRepository
extends JpaRepository<customer, Integer> {
    Optional<customer> findByEmail(String email);
//    Optional<customer> findByCustomerID(int id);

}
