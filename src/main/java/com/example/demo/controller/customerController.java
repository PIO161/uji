package com.example.demo.controller;

import com.example.demo.entitas.customer;
import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class customerController {

    @Autowired
    private userService customerService;

    // Endpoint to get a customer by ID
    @GetMapping("/{id}")
    public ResponseEntity<customer> getCustomerById(@PathVariable int id) {
        Optional<customer> customer = customerService.getCustomerById(id);
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        }
        return ResponseEntity.notFound().build();
    }
}
