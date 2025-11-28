package main.eshopapi.services;

import main.eshopapi.entities.Product;
import main.eshopapi.entities.Vendor;
import main.eshopapi.repositories.IProductRepository;
import main.eshopapi.repositories.IVendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostProductService {

    private final IProductRepository productRepository;
//    private final IVendorRepository vendorRepository;

    public PostProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
//        this.vendorRepository = vendorRepository;
    }

    @Transactional
    public void postProduct(Product p, Long vendorId) {

//        Vendor v = vendorRepository.findVendorById(vendorId);
//        v.addProduct(p);
        productRepository.addProduct(vendorId, p.getName(), p.getDescription(), p.getPrice(), p.getAmount());
    }
}
