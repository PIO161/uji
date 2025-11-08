package com.example.demo.controller;

import com.example.demo.entitas.pesanan;
import com.example.demo.repository.pesananRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private pesananRepository pesananRepo;

    // Tampilkan halaman orders
    @GetMapping("/orders")
    public String viewOrders(Model model) {
        List<pesanan> allOrders = pesananRepo.findAll();
        model.addAttribute("orders", allOrders);
        return "orders"; // akan kita buat views/orders.html
    }

    // Ubah tracking status pesanan
    @PostMapping("/orders/update-tracking/{id}")
    public String updateTrackingStatus(@PathVariable int id, @RequestParam String trackingStatus) {
        pesanan p = pesananRepo.findById(id).orElse(null);
        if (p != null) {
            p.setTrackingStatus(trackingStatus);
            pesananRepo.save(p);
        }
        return "redirect:/admin/orders";
    }

    @GetMapping("/api/pesanan")
@ResponseBody
public List<pesanan> getAllPesanan() {
    return pesananRepo.findAll();
}

}
