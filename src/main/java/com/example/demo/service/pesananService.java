package com.example.demo.service;

import com.example.demo.entitas.customer;
import com.example.demo.entitas.menu;
import com.example.demo.entitas.pesanan;
import com.example.demo.repository.customerRepository;
import com.example.demo.repository.menuRepository;
import com.example.demo.repository.pesananRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class pesananService {

    @Autowired
    private pesananRepository pesananRepository;

    @Autowired
    private menuRepository menuRepository;

    @Autowired
    private customerRepository customerRepository;

    // Create pesanan
    public pesanan buatPesanan(int menuId, int customerId) throws Exception {
        Optional<menu> menuOptional = menuRepository.findById(menuId);
        Optional<customer> customerOptional = customerRepository.findById(customerId);

        if (menuOptional.isEmpty()) {
            throw new Exception("Menu dengan ID " + menuId + " tidak ditemukan");
        }

        if (customerOptional.isEmpty()) {
            throw new Exception("Customer dengan ID " + customerId + " tidak ditemukan");
        }

        menu menu = menuOptional.get();
        customer customer = customerOptional.get();

        int hargaMenu = menu.getHarga();
        int promo = menu.getPromo();
        int hargaFinal = hargaMenu - (hargaMenu * promo / 100);


        pesanan pesananBaru = new pesanan();
        pesananBaru.setMenu(menu);
        pesananBaru.setCustomer(customer);
        pesananBaru.setStatus("Pending");
        pesananBaru.setHarga(hargaFinal);

        return pesananRepository.save(pesananBaru);
    }

    // Update pesanan
    public pesanan updatePesanan(int pesananId, String status) throws Exception {
        Optional<pesanan> pesananOptional = pesananRepository.findById(pesananId);

        if (pesananOptional.isEmpty()) {
            throw new Exception("Pesanan dengan ID " + pesananId + " tidak ditemukan");
        }

        pesanan pesanan = pesananOptional.get();
        pesanan.setStatus(status);

        return pesananRepository.save(pesanan);
    }

    public Optional<customer> getCustomerByCustomerID(int customerID) {
        return customerRepository.findById(customerID);
    }

    public List<pesanan> getAllPesananByCustomerId(int customerId) {
        return pesananRepository.findAllByCustomerId(customerId);
    }

    // Delete pesanan
    public void deletePesanan(int pesananId) throws Exception {
        if (!pesananRepository.existsById(pesananId)) {
            throw new Exception("Pesanan dengan ID " + pesananId + " tidak ditemukan");
        }

        pesananRepository.deleteById(pesananId);
    }

    // Get pesanan by ID
    public pesanan getPesananById(int pesananId) throws Exception {
        return pesananRepository.findById(pesananId)
                .orElseThrow(() -> new Exception("Pesanan dengan ID " + pesananId + " tidak ditemukan"));
    }

    // Get all pesanan
    public List<pesanan> getAllPesanan() {
        return pesananRepository.findAll();
    }
}
