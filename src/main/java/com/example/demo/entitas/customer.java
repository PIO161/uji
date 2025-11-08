package com.example.demo.entitas;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class customer extends user {


    @Column(name = "CustomerID", nullable = false)
    private String customerID;

    @Override
    public boolean login(String email, String password) {
        // Logika login khusus untuk customer
        return email.endsWith("@customer.com") && password.length() > 5;
    }

    @Column(name = "CustomerNama", nullable = false)
    private String customerNama;

    // Constructor
    public customer() {}

    public customer(String customerID, String customerNama) {
        this.customerID = customerID;
        this.customerNama = customerNama;
    }

    // Getter dan Setter
    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerNama() {
        return customerNama;
    }

    public void setCustomerNama(String customerNama) {
        this.customerNama = customerNama;
    }
}
