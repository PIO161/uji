package com.example.demo.repository;

import com.example.demo.entitas.user;
import org.springframework.data.jpa.repository.JpaRepository;


public interface userRepository extends JpaRepository<user, Integer> {
    // Metode untuk menemukan pengguna berdasarkan email
//     user findByEmail(String email);
//     boolean existsByEmail(String email);

}
