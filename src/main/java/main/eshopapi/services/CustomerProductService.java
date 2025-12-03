package main.eshopapi.services;

import main.eshopapi.repositories.ICustomerRepository;
import main.eshopapi.repositories.IProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerProductService {

    private final ICustomerRepository customerRepository;
    private final IProductRepository productRepository;

    public CustomerProductService(ICustomerRepository customerRepository, IProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    public void addToCart(Long productId, Long customerId) {

    }
}
