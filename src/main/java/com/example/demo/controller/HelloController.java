package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/home.html")
    public String home() {
        return "home.html";
    }

    @GetMapping("/")
    public String index() {
        return "ind";
    }

    @GetMapping("/login.html")
    public String login() {
        return "login.html";
    }

    @GetMapping("/logout.html")
    public String logout() {
        return "logout.html";
    }

    @GetMapping("/register.html")
    public String register() {
        return "register.html";
    }

    @GetMapping("/add-menu")
    public String showAddMenuPage(Model model, HttpSession session) {
        // Cek apakah user ada di sesi
        Long adminIdLong = (Long) session.getAttribute("adminId");
        Integer adminId = adminIdLong != null ? adminIdLong.intValue() : null;

        if (adminId == null) {
            throw new RuntimeException("Admin tidak ditemukan di sesi. Silakan login kembali.");
        }

        // Tambahkan atribut user ke model
        model.addAttribute("user", "Admin " + adminId);
        return "add-menu";
    }


//    @GetMapping("/admin")
//    public String adminPage(Model model, HttpSession session) {
//        Long adminIdLong = (Long) session.getAttribute("adminId");
//        Integer adminId = adminIdLong != null ? adminIdLong.intValue() : null;
//
//        if (adminId == null) {
//            throw new RuntimeException("Admin tidak ditemukan di sesi. Silakan login kembali.");
//        }
//        System.out.println("Admin ID from session: " + adminId);
//
//        model.addAttribute("adminId", adminId); // Tambahkan adminId ke model
//        model.addAttribute("pageTitle", "Admin Panel");
//
//        return "admin";
//    }

    @GetMapping("/customer")
    public String customerPage(Model model, HttpSession session) {
        Long customerIdLong = (Long) session.getAttribute("customerId");
        Integer customerId = customerIdLong != null ? customerIdLong.intValue() : null;

        if (customerId == null) {
            throw new RuntimeException("Customer tidak ditemukan di sesi. Silakan login kembali.");
        }
        System.out.println("Customer ID from session: " + customerId);

        model.addAttribute("customerId", customerId); // Tambahkan customerId ke model
        model.addAttribute("pageTitle", "Customer Panel");

        return "customer";
    }

    @GetMapping("/login-admin")
    public String loginAdmin() {
        return "login-admin";
    }

    @GetMapping("/register-admin")
    public String registerAdmin() {
        return "register-admin";
    }

    @GetMapping("/listmenu.html")
    public String listmenu() {
        return "listmenu.html";
    }

    @GetMapping("/ordermenu.html")
    public String ordermenu() {
        return "ordermenu.html";
    }

    @GetMapping("/pembayaran.html")
    public String pembayaran() {
        return "pembayaran.html";
    }

    @GetMapping("/prosespembayaran.html")
    public String prosespembayaran() {
        return "prosespembayaran.html";
    }

    @GetMapping("/updated.html")
    public String updateMenu() {
        return "updated.html";
    }
}
