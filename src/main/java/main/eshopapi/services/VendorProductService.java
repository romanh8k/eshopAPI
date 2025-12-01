package main.eshopapi.services;

import main.eshopapi.entities.Product;
import main.eshopapi.repositories.IProductRepository;
import main.eshopapi.repositories.IVendorRepository;
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

    public void deleteVendor(Long id) {
        productRepository.deleteProductsByVendorId(id);
        vendorRepository.deleteVendor(id);
    }

    public void addProduct(Product p) {
        if (vendorRepository.findVendorById(p.getVendorId()) == null) {
            logger.warning("Vendor with vendor_id = " + p.getVendorId() + " doesn't exist");
        }
        else {
            productRepository.addProduct(p.getVendorId(), p.getName(), p.getDescription(), p.getPrice(), p.getAmount());
        }
    }
}
