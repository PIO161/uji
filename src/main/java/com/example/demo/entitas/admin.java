package com.example.demo.entitas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin")
public class admin extends user {

    @Override
    public boolean login(String email, String password) {
        // Logika login khusus untuk admin
        return email.equals("admin@example.com") && password.equals("admin123");
    }

    @Column(name = "AdminID", nullable = false)
    private String adminID;

    @Column(nullable = false)  // Pastikan properti ini tidak boleh null
    private String adminNama;

    // Constructor
    public admin() {}

    public admin(String adminID, String adminNama) {
        this.adminID = adminID;
        this.adminNama = adminNama;
    }

    // Getter dan Setter
    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getAdminNama() {
        return adminNama;
    }

    public void setAdminNama(String adminNama) {
        this.adminNama = adminNama;
    }
}
