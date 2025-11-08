package com.example.demo.repository;
import com.example.demo.entitas.admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
// Interface
public interface adminRepository
extends JpaRepository<admin, Integer> {
    Optional<admin> findByEmail(String email);

}
