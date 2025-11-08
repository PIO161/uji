package com.example.demo.service;

import com.example.demo.entitas.pembayaran;
import com.example.demo.repository.pembayaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class pembayaranService {
@Autowired
private pembayaranRepository pembayaranRepository;
public List<pembayaran> getAllPembayaran() {
    return pembayaranRepository.findAll();
    }
    public pembayaran getpembayaranById(int id) {
    return pembayaranRepository.findById(id).orElse(null);
    }
    public pembayaran updatepembayaran(int id, pembayaran pembayaran) {
            pembayaran.setId(id); // Pastikan ID diatur
            return pembayaranRepository.save(pembayaran);
        }
        public void deletepembayaran(int id) {
            pembayaranRepository.deleteById(id);
        }
}
