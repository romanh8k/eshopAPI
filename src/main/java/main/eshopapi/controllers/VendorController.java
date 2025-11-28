package main.eshopapi.controllers;

import main.eshopapi.entities.Product;
import main.eshopapi.entities.Vendor;
import main.eshopapi.services.ManageVendorService;
import main.eshopapi.services.PostProductService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class VendorController {

    private final PostProductService postProductService;
    private final ManageVendorService manageVendorService;

    public VendorController(PostProductService postProductService, ManageVendorService manageVendorService) {
        this.postProductService = postProductService;
        this.manageVendorService = manageVendorService;
    }

    @GetMapping(value = "/vendors")
    public List<Vendor> findAll() {
        return manageVendorService.findAll();
    }

    @GetMapping(value = "/vendors", params = "id")
    public Vendor findVendorById(@RequestParam Long id) {
        return manageVendorService.findVendorById(id);
    }

    @GetMapping(value = "/vendors", params = "name")
    public List<Vendor> findVendorsByName(@RequestParam String name) {
        return manageVendorService.findVendorsByName(name);
    }

    @PostMapping(value = "/vendors", params = "vendorId")
    public void postProduct(@RequestBody Product product, @RequestParam Long vendorId) {
        postProductService.postProduct(product, vendorId);
    }

    @PostMapping(value = "/vendors")
    public void addVendor(@RequestBody String name) {
        manageVendorService.addVendor(name);
    }
}
