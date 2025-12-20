package main.eshopapi.services;

import jakarta.transaction.Transactional;
import lombok.extern.java.Log;
import main.eshopapi.dtos.BuyDTO;
import main.eshopapi.dtos.ProductLogged;
import main.eshopapi.entities.Customer;
import main.eshopapi.entities.Product;
import main.eshopapi.entities.Vendor;
import main.eshopapi.repositories.IProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.logging.Logger;

@Service
public class BuyService {

    private ManageVendorService manageVendorService;
    private ManageCustomerService manageCustomerService;
    private IProductRepository productRepository;
    private Logger logger = Logger.getLogger(BuyService.class.getName());

    public BuyService(ManageVendorService manageVendorService,
                      ManageCustomerService manageCustomerService,
                      IProductRepository productRepository) {
        this.manageVendorService = manageVendorService;
        this.manageCustomerService = manageCustomerService;
        this.productRepository = productRepository;
    }

    @Transactional
    public void buyProduct(BuyDTO receipt) {
        Customer c = manageCustomerService.findCustomerById(receipt.getCustomerId());
        Product p = productRepository.findProductById(receipt.getProductId());
        Vendor v = manageVendorService.findVendorById(p.getVendorId());

        BigDecimal addPrice = new BigDecimal(p.getPrice());
        BigDecimal subPrice = addPrice.multiply(new BigDecimal(-1.0));

        if (c.getWallet().compareTo(new BigDecimal(p.getPrice())) != -1) {
            manageCustomerService.editWallet(receipt.getCustomerId(), subPrice);
            productRepository.deleteProductById(receipt.getProductId());
            manageVendorService.editWallet(p.getVendorId(), addPrice);
            logger.info("Bought successfully!");
        }
        else {
            logger.warning("Not enough money!");
        }
    }

}
