package main.eshopapi.services;

import main.eshopapi.entities.Product;
import main.eshopapi.repositories.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageProductService {

    private IProductRepository productRepository;

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
}
