package main.eshopapi.controllers;

import main.eshopapi.dtos.ProductLogged;
import main.eshopapi.entities.Product;
import main.eshopapi.services.ManageProductService;
import main.eshopapi.services.VendorProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ManageProductService manageProductService;
    private final VendorProductService vendorProductService;

    public ProductController(ManageProductService manageProductService, VendorProductService vendorProductService) {
        this.manageProductService = manageProductService;
        this.vendorProductService = vendorProductService;
    }

    @GetMapping("/products")
    public List<Product> findAll() {
        return manageProductService.findAll();
    }

    @GetMapping(value = "/products", params = "id")
    public Product findProductById(@RequestParam Long id) {
        return manageProductService.findProductById(id);
    }

    @GetMapping(value = "/products", params = "name")
    public List<Product> findProductsByName(@RequestParam String name) {
        return manageProductService.findProductsByName(name);
    }

    @GetMapping(value = "/products", params = {"lowerBound", "upperBound"})
    public List<Product> findProductsInPriceInterval(@RequestParam double lowerBound, @RequestParam double upperBound) {
        return manageProductService.findProductsInPriceInterval(lowerBound, upperBound);
    }

    @GetMapping(value = "/products", params = {"name", "lowerBound", "upperBound"})
    public List<Product> findProductsByNameInPriceInterval(@RequestParam String name, @RequestParam double lowerBound, @RequestParam double upperBound) {
        return manageProductService.findProductsByNameInPriceInterval(name, lowerBound, upperBound);
    }

    @GetMapping(value = "/products", params = "vendorId")
    public List<Product> findProductsByVendorId(@RequestParam Long vendorId) {
        return manageProductService.findProductsByVendorId(vendorId);
    }

    @PostMapping(value = "/products")
    public void postProduct(@RequestBody ProductLogged p) {
        vendorProductService.addProduct(p);
    }

    @PutMapping(value = "/products")
    public void editProduct(@RequestBody ProductLogged p) {
        vendorProductService.editProduct(p);
    }

    @DeleteMapping(value = "/products")
    public void deleteProduct(@RequestBody ProductLogged p) {
        vendorProductService.deleteProduct(p);
    }

}
