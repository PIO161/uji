package com.example.demo.repository;
import com.example.demo.entitas.menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
// Interface
public interface menuRepository
extends JpaRepository<menu, Integer> {
}
