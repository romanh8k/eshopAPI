package main.eshopapi.services;

import main.eshopapi.entities.Product;
import main.eshopapi.repositories.IProductRepository;
import main.eshopapi.repositories.IVendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorProductService {

    private final IVendorRepository vendorRepository;
    private final IProductRepository productRepository;

    public VendorProductService(IVendorRepository vendorRepository, IProductRepository productRepository) {
        this.vendorRepository = vendorRepository;
        this.productRepository = productRepository;
    }
}
