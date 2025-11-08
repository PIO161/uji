package com.example.demo.entitas;

import jakarta.persistence.*;
@Entity
@Table(name = "pembayaran")
public class pembayaran{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(name = "PembayaranID")
private String PembayaranID;
@Column(name = "CustomerID")
private String CustomerID;
@Column(name = "PesananID")
private String PesananID;

public pembayaran() {}
public pembayaran(String PembayaranID, String CustomerID, String PesananID) {
this.PembayaranID = PembayaranID;
this.CustomerID = CustomerID;
this.PesananID = PesananID;
}
public int getId() {
    return id;
    }
    public void setId(int id) {
    this.id = id;
    }
    public void setPembayaranID(String PembayaranID) {
    this.PembayaranID = PembayaranID;
    }
    public String getPembayaranID() {
    return PembayaranID;
    }
    public void setCustomerID(String CustomerID) {
    this.CustomerID = CustomerID;
    }
    public String getCustomerID() {
    return CustomerID;
    }
    public void setPesananID(String PesananID) {
        this.PesananID = PesananID;
        }
        public String getPesananID() {
        return PesananID;
        }
        }
        