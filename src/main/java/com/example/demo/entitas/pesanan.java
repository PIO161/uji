package com.example.demo.entitas;

import jakarta.persistence.*;

@Entity
@Table(name = "pesanan")
public class pesanan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "MenuID", nullable = false)
    private menu menu;

    @ManyToOne
    @JoinColumn(name = "CustomerID", nullable = false)
    private customer customer;

    @Column(name = "Status", nullable = false)
    private String status;

    @Column(name = "Harga", nullable = false)
    private int harga;

    @Column(name = "tracking_status")
    private String trackingStatus = "Order Placed";


    // Constructors
    public pesanan() {}

    public pesanan(menu menu, customer customer, String status, int harga) {
        this.menu = menu;
        this.customer = customer;
        this.status = status;
        this.harga = harga;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public menu getMenu() {
        return menu;
    }

    public void setMenu(menu menu) {
        this.menu = menu;
    }

    public customer getCustomer() {
        return customer;
    }

    public void setCustomer(customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getTrackingStatus() {
    return trackingStatus;
}

    public void setTrackingStatus(String trackingStatus) {
    this.trackingStatus = trackingStatus;
}

}
