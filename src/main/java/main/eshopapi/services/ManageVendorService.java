package main.eshopapi.services;

import main.eshopapi.entities.Vendor;
import main.eshopapi.repositories.IVendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageVendorService {

    private final IVendorRepository vendorRepository;

    public ManageVendorService(IVendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public List<Vendor> findAll() {
        return vendorRepository.findAll();
    }

    public Vendor findVendorById(Long id) {
        return vendorRepository.findVendorById(id);
    }

    public List<Vendor> findVendorsByName(String name) {
        return vendorRepository.findVendorsByName(name);
    }

    public void addVendor(Vendor vendor) {
        vendorRepository.addVendor(vendor.getName(), vendor.getEmail(), vendor.getPassword());
    }

    public void editVendor(Vendor vendor) {

        if (vendor.getName() != null) {
            vendorRepository.setVendorName(vendor.getId(), vendor.getName());
        }

        if (vendor.getWallet() != null) {
            vendorRepository.setVendorWallet(vendor.getId(), vendor.getWallet());
        }
    }

    public Vendor findVendorByEmail(String email) {
        return vendorRepository.findVendorByEmail(email);
    }
}
