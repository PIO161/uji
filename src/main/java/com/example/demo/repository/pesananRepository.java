package com.example.demo.repository;
import com.example.demo.entitas.pesanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// Interface
public interface pesananRepository
extends JpaRepository<pesanan, Integer> {
    List<pesanan> findAllByCustomerId(int customerId);

}
