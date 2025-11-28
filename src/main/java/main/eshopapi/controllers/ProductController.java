package main.eshopapi.controllers;

import main.eshopapi.entities.Product;
import main.eshopapi.entities.Vendor;
import main.eshopapi.repositories.IProductRepository;
import main.eshopapi.services.ManageProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ManageProductService manageProductService;

    public ProductController(ManageProductService manageProductService) {
        this.manageProductService = manageProductService;
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

}
