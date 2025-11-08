package com.example.demo.controller;

import com.example.demo.service.menuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class menuController {

    @Autowired
    private menuService menuService;

    @DeleteMapping("/menu/delete/{id}")
    public ResponseEntity<String> deleteMenu(@PathVariable int id) {
        try {
            menuService.deletemenu(id); // Memanggil service untuk menghapus menu
            return ResponseEntity.ok().body("Menu berhasil dihapus.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error menghapus menu: " + e.getMessage());
        }
    }
}
