package main.eshopapi.services;

import main.eshopapi.entities.Vendor;
import main.eshopapi.repositories.IVendorRepository;
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

    public List<Vendor> findVendorsByName(String name) {
        return vendorRepository.findVendorsByName(name);
    }
}
