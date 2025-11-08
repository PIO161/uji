package com.example.demo.controller;

import com.example.demo.entitas.admin;
import com.example.demo.entitas.customer;
import com.example.demo.service.userService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
//@RequestMapping("/api/users")
public class userController {

    @Autowired
    private userService userService;

    // Register Admin
    @PostMapping("/register/admin")
    public ResponseEntity<?> registerAdmin(@RequestBody Map<String, Object> body, HttpSession session) {
        String name = (String) body.get("name");
        String email = (String) body.get("email");
        String password = (String) body.get("password");

        if (name == null || email == null || password == null || name.isBlank() || email.isBlank() || password.isBlank()) {
            return ResponseEntity.badRequest().body("Required parameters 'name', 'email', and 'password' must not be empty.");
        }

        admin newAdmin = userService.registerAdmin(name, email, password);

        // Simpan adminId ke dalam sesi setelah berhasil mendaftar
        session.setAttribute("adminId", newAdmin.getId());

        return ResponseEntity.status(302) // Status redirect
                .header("Location", "/login") // Header lokasi untuk pengalihan
                .build();
    }

//    @GetMapping("/register")
//    public String showRegisterPage(Model model) {
//        model.addAttribute("user", new customer()); // Atau new Customer()
//        return "register"; // Mengacu pada src/main/resources/templates/register.html
//    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // Mengacu pada src/main/resources/templates/register.html
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Mengacu ke login.html di templates
    }

    // Register Customer
    @PostMapping("/register/customer")
    public ResponseEntity<?> registerCustomer(@RequestBody Map<String, Object> body) {
        String name = (String) body.get("name");
        String email = (String) body.get("email");
        String password = (String) body.get("password");

        if (name == null || email == null || password == null || name.isBlank() || email.isBlank() || password.isBlank()) {
            return ResponseEntity.badRequest().body("Required parameters 'name', 'email', and 'password' must not be empty.");
        }

        customer newCustomer = userService.registerCustomer(name, email, password);
        return ResponseEntity.status(302) // Status redirect
                .header("Location", "/login") // Header lokasi untuk pengalihan
                .build();
    }


    // Login Admin
    @PostMapping("/login/admin")
    public ResponseEntity<Object> loginAdmin(@RequestBody Map<String, Object> body, HttpSession session) {
        if (body == null || !body.containsKey("email") || !body.containsKey("password")) {
            return ResponseEntity.badRequest().body("Missing required fields: 'email' and 'password'");
        }

        String email = (String) body.get("email");
        String password = (String) body.get("password");

        if (email == null || email.isBlank() || password == null || password.isBlank()) {
            return ResponseEntity.badRequest().body("Email and password must not be empty");
        }

        // Proses login melalui service
        return userService.loginAdmin(email, password)
                .<ResponseEntity<Object>>map(admin -> {
                    // Simpan adminId ke dalam sesi
                    session.setAttribute("adminId", admin.getId());
                    // Login berhasil, kirim respons sukses dan URL untuk redirect
                    return ResponseEntity.ok(Map.of(
                            "message", "Login Successful",
                            "redirectUrl", "/admin" // Ganti sesuai URL dashboard admin
                    ));
                })
                .orElse(ResponseEntity.status(401).body("Invalid credentials")); // Respons gagal
    }

    // Login Customer
    @PostMapping("/login/customer")
    public ResponseEntity<Object> loginCustomer(@RequestBody Map<String, Object> body, HttpSession session) {
        // Validasi untuk memastikan data tidak null atau kosong
        if (body == null || !body.containsKey("email") || !body.containsKey("password")) {
            return ResponseEntity.badRequest().body("Missing required fields: 'email' and 'password'");
        }

        // Parsing dan validasi nilai dari request body
        String email = (String) body.get("email");
        String password = (String) body.get("password");

        if (email == null || email.isBlank() || password == null || password.isBlank()) {
            return ResponseEntity.badRequest().body("Email and password must not be empty");
        }

        // Proses login melalui service
        return userService.loginCustomer(email, password)
                .<ResponseEntity<Object>>map(customer -> {
                    // Simpan customerId ke dalam sesi
                    session.setAttribute("customerId", customer.getId());  // Pastikan ini diset
                    // Login berhasil, kirim respons sukses dan URL untuk redirect
                    return ResponseEntity.ok(Map.of(
                            "message", "Login Successful",
                            "redirectUrl", "/customer"
                    ));
                })
                .orElse(ResponseEntity.status(401).body("Invalid credentials")); // Respons gagal
    }



}
