package com.example.demo.service;

import com.example.demo.entitas.menu;
import com.example.demo.repository.menuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class menuService {
   @Autowired
private menuRepository menuRepository;
public List<menu> getAllmenu() {
    List<menu> menus = menuRepository.findAll();
    System.out.println("Menus retrieved: " + menus);
    return menus;
    }
    public menu getmenuById(int id) {
    return menuRepository.findById(id).orElse(null);
    }

    public menu updatemenu(int id, menu request) {
        menu menus = menuRepository.findById(id).orElse(null);
        if (menus == null) {
            return null; // Jika data dengan ID tidak ditemukan
        }
        menus.setNamaMenu(request.getNamaMenu());
        menus.setHarga(request.getHarga());
        menus.setPromo(request.getPromo());
        menus.setImage(request.getImage());
        return menuRepository.save(menus);
    }

    public void deletemenu(int id) {
        menuRepository.deleteById(id);
    }

    public void addMenu(menu request) {
        menu menus = new menu();
        menus.setNamaMenu(request.getNamaMenu());
        menus.setHarga(request.getHarga());
        menus.setPromo(request.getPromo());
        menus.setImage(request.getImage());
        menuRepository.save(menus);
    }


}
