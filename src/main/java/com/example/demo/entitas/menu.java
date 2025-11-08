package com.example.demo.entitas;

import jakarta.persistence.*;
@Entity
@Table(name = "menu")
public class menu {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name = "namaMenu")
private String namaMenu;

@Column(name = "Harga")
private Integer Harga;

@Column(name = "Promo")
private Integer Promo;

@Column(name = "Image")
private String Image;

public menu() {}
public menu( String namaMenu, Integer Harga, Integer Promo, String Image) {
this.namaMenu = namaMenu;
this.Harga = Harga;
this.Promo = Promo;
this.Image = Image;
}
public int getId() {
    return id;
    }
    public void setId(int id) {
    this.id = id;
    }

    public void setHarga(Integer Harga) {
    this.Harga = Harga;
    }
    public Integer getHarga() {
    return Harga;
    }

    public void setNamaMenu(String namaMenu) {
    this.namaMenu = namaMenu;
    }
    public String getNamaMenu() {
    return namaMenu;
    }

    public void setPromo(Integer Promo) {
    this.Promo = Promo;
    }
    public Integer getPromo() {
    return Promo;
    }

    public void setImage(String Image) {
        this.Image = Image;
        }
        public String getImage() {
        return Image;
        }
}
