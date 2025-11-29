package main.eshopapi.services;

import main.eshopapi.entities.Product;
import main.eshopapi.repositories.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageProductService {

    private final IProductRepository productRepository;

    public ManageProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        return productRepository.findProductById(id);
    }

    public List<Product> findProductsByName(String name) {
        return productRepository.findProductsByName(name);
    }

    public List<Product> findProductsByPrice(double price) {
        return productRepository.findProductsByPrice(price);
    }

    public List<Product> findProductsInPriceInterval(double lowerBound, double upperBound) {
        return productRepository.findProductsInPriceInterval(lowerBound, upperBound);
    }

    public List<Product> findProductsByNameInPriceInterval(String name, double lowerBound, double upperBound) {
        return productRepository.findProductsByNameInPriceInterval(name, lowerBound, upperBound);
    }

    public List<Product> findProductsByVendorId(Long vendorId) {
        return productRepository.findProductsByVendorId(vendorId);
    }

    public void addProduct(Product p) {
        productRepository.addProduct(p.getVendorId(), p.getName(), p.getDescription(), p.getPrice(), p.getAmount());
    }

    public void editProduct(Product p) {
        if (p.getName() != null) {
            productRepository.editProductName(p.getId(), p.getName());
        }
        if (p.getPrice() != 0.0) {
            productRepository.editProductPrice(p.getId(), p.getPrice());
        }
        if (p.getDescription() != null) {
            productRepository.editProductDescription(p.getId(), p.getDescription());
        }
        if (p.getAmount() != 0) {
            productRepository.editProductAmount(p.getId(), p.getAmount());
        }
    }
}
