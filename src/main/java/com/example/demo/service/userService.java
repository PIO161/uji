package com.example.demo.service;

import com.example.demo.entitas.admin;
import com.example.demo.entitas.customer;
import com.example.demo.repository.adminRepository;
import com.example.demo.repository.customerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class userService {

    @Autowired
    private adminRepository adminRepository;

    @Autowired
    private customerRepository customerRepository;

    // Register Admin
    public admin registerAdmin(String name, String email, String password) {
        admin newAdmin = new admin();
        newAdmin.setName(name);
        newAdmin.setEmail(email);
        newAdmin.setAdminNama(name);  // Set adminNama dengan nilai yang valid
        newAdmin.setPassword((password)); // Hash password
        newAdmin.setRole("ADMIN"); // Set default role
        newAdmin.setAdminID("ADM" + System.currentTimeMillis()); // Unique ID
        adminRepository.save(newAdmin);
        return newAdmin;
    }

    // Register Customer
    public customer registerCustomer(String name, String email, String password) {
        customer newCustomer = new customer();
        newCustomer.setName(name);
        newCustomer.setEmail(email);
        newCustomer.setCustomerNama(name);
        newCustomer.setPassword((password)); // Hash password
        newCustomer.setCustomerID("CUS" + System.currentTimeMillis()); // Generate unique customer ID
        newCustomer.setRole("CUSTOMER"); // Set default role
        // Simpan logika hash password di sini jika diperlukan
        customerRepository.save(newCustomer);
        return newCustomer;
    }

    // Login Admin
    public Optional<admin> loginAdmin(String email, String password) {
        // Cari admin berdasarkan email
        Optional<admin> adminOpt = adminRepository.findByEmail(email);

        if (adminOpt.isPresent()) {
            admin admin = adminOpt.get();

            // Validasi email dan password
            if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
                return Optional.of(admin);
            }
        }

        // Jika tidak valid, kembalikan Optional kosong
        return Optional.empty();
    }

    // Login Customer
    public Optional<customer> loginCustomer(String email, String password) {
        // Cari admin berdasarkan email
        Optional<customer> cust = customerRepository.findByEmail(email);

        if (cust.isPresent()) {
            customer req = cust.get();

            // Validasi email dan password
            if (req.getEmail().equals(email) && req.getPassword().equals(password)) {
                return Optional.of(req);
            }
        }

        // Jika tidak valid, kembalikan Optional kosong
        return Optional.empty();
    }

    public Optional<customer> getCustomerById(int id) {
        return customerRepository.findById(id);
    }
}
