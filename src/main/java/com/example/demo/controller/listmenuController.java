package com.example.demo.controller;

import com.example.demo.entitas.menu;
import com.example.demo.service.menuService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class listmenuController {

    @Autowired
    private menuService menuService;

    @GetMapping("/admin")
    public String adminPage(Model model, HttpSession session) {
        // Ambil adminId dari sesi
        Long adminIdLong = (Long) session.getAttribute("adminId");
        Integer adminId = adminIdLong != null ? adminIdLong.intValue() : null;

        if (adminId == null) {
            throw new RuntimeException("Admin tidak ditemukan di sesi. Silakan login kembali.");
        }

        System.out.println("Admin ID from session: " + adminId);

        // Tambahkan atribut user ke model
        model.addAttribute("user", "Admin " + adminId);

        // Ambil daftar menu
        List<menu> menus = menuService.getAllmenu();
        if (menus == null || menus.isEmpty()) {
            model.addAttribute("errorMessage", "Data menu tidak ditemukan.");
        } else {
            model.addAttribute("menus", menus);
        }

        model.addAttribute("adminId", adminId);
        model.addAttribute("pageTitle", "Admin Panel");

        return "admin";
    }


    @GetMapping("/listmenu")
    public String listmenuPage(@RequestParam(value = "customerId", required = false) String customerId, Model model) {
        List<menu> menus = menuService.getAllmenu();
        if (menus == null || menus.isEmpty()) {
            model.addAttribute("errorMessage", "Data menu tidak ditemukan.");
        } else {
            model.addAttribute("menus", menus);
        }

        // Tambahkan customerId ke model (jika dibutuhkan di template)
        model.addAttribute("customerId", customerId);
        return "listmenu";
    }


    @PostMapping("/add")
    public ResponseEntity<Object> addMenu(@RequestBody menu request) {
        try {
            menuService.addMenu(request); // Menambahkan menu melalui service
            return ResponseEntity.ok().body("{\"message\":\"Menu berhasil ditambahkan\"}"); // Respons dalam format JSON
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"message\":\"Error adding menu: " + e.getMessage() + "\"}"); // Respons error dalam format JSON
        }
    }

    @GetMapping("/update-menu/{id}")
    public String updateMenu(@PathVariable("id") int id, Model model) {
        menu menuData = menuService.getmenuById(id);
        if (menuData == null) {
            model.addAttribute("error", "Menu not found");
            return "error"; // Map to a specific error page
        }
        model.addAttribute("menu", menuData);
        return "update-menu";
    }


    @PostMapping("/update-menu/{id}")
    public String updateMenu(@PathVariable("id") int id,
                             menu updatedMenu,
                             HttpSession session) {
        // Periksa apakah adminId ada di sesi
        Long adminIdLong = (Long) session.getAttribute("adminId");
        Integer adminId = adminIdLong != null ? adminIdLong.intValue() : null;

        if (adminId == null) {
            throw new RuntimeException("Akses ditolak. Hanya admin yang dapat melakukan aksi ini.");
        }

        // Lakukan update jika adminId valid
        menuService.updatemenu(id, updatedMenu);
        return "redirect:/admin"; // Redirect ke daftar menu
    }



}

