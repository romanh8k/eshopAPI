package main.eshopapi.services;

import main.eshopapi.dtos.ProductLogged;
import main.eshopapi.dtos.VendorLogged;
import main.eshopapi.entities.Product;
import main.eshopapi.entities.Vendor;
import main.eshopapi.repositories.IProductRepository;
import main.eshopapi.repositories.IVendorRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class VendorProductService {

    private final IVendorRepository vendorRepository;
    private final IProductRepository productRepository;

    Logger logger = Logger.getLogger(VendorProductService.class.getName());

    public VendorProductService(IVendorRepository vendorRepository, IProductRepository productRepository) {
        this.vendorRepository = vendorRepository;
        this.productRepository = productRepository;
    }

    public void deleteVendor(Long id, String password) {
        PasswordEncoder b = new BCryptPasswordEncoder();
        Vendor v = vendorRepository.findVendorById(id);
        if (b.matches(password, v.getPassword())) {
            productRepository.deleteProductsByVendorId(id);
            vendorRepository.deleteVendor(id);
        }
    }

    public void addProduct(ProductLogged p) {
        if (vendorRepository.findVendorById(p.getVendorId()) == null) {
            logger.warning("Vendor with vendor_id = " + p.getVendorId() + " doesn't exist");
        }
        else if (new BCryptPasswordEncoder().matches(p.getVendorPassword(), vendorRepository.findVendorById(p.getVendorId()).getPassword())) {
            productRepository.addProduct(p.getVendorId(), p.getName(), p.getDescription(), p.getPrice(), p.getAmount());
        }
    }

    public void editProduct(ProductLogged p) {
        if (new BCryptPasswordEncoder().matches(p.getVendorPassword(), vendorRepository.findVendorById(p.getVendorId()).getPassword())) {
            if (p.getName() != null) {
                productRepository.editProductName(p.getId(), p.getName());
            }
            if (p.getDescription() != null) {
                productRepository.editProductDescription(p.getId(), p.getDescription());
            }
        }
    }

    public void deleteProduct(ProductLogged p) {
        if (new BCryptPasswordEncoder().matches(p.getVendorPassword(), vendorRepository.findVendorById(p.getVendorId()).getPassword())) {
            productRepository.deleteProductById(p.getId());
        }
    }
}
