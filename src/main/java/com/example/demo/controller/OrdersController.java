package com.example.demo.controller;

import com.example.demo.entitas.Orders;
import com.example.demo.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrdersController {

    @Autowired
    private OrdersRepository ordersRepo;

    // Tampilkan semua pesanan
    @GetMapping("/orders")
    public String showOrders(Model model) {
        List<Orders> list = ordersRepo.findAll();
        model.addAttribute("orders", list);
        return "orders"; // Harus ada file templates/orders.html
    }

    // Update tracking status (opsional)
    @PostMapping("/orders/update/{id}")
    public String updateTracking(@PathVariable int id, @RequestParam String trackingStatus) {
        Orders o = ordersRepo.findById(id).orElse(null);
        if (o != null) {
            o.setTrackingStatus(trackingStatus);
            ordersRepo.save(o);
        }
        return "redirect:/orders";
    }
}
