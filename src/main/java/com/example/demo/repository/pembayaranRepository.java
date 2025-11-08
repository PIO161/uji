package com.example.demo.repository;

import com.example.demo.entitas.pembayaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
// Interface
public interface pembayaranRepository
extends JpaRepository<pembayaran, Integer> {
}
