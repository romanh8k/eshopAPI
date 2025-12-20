package main.eshopapi.controllers;

import main.eshopapi.dtos.SignUpDTO;
import main.eshopapi.dtos.VendorLogged;
import main.eshopapi.entities.Vendor;
import main.eshopapi.services.ManageVendorService;
import main.eshopapi.services.VendorProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VendorController {

//    private final PostProductService postProductService;
    private final ManageVendorService manageVendorService;
    private final VendorProductService vendorProductService;

    public VendorController(ManageVendorService manageVendorService, VendorProductService vendorProductService) {
//        this.postProductService = postProductService;
        this.manageVendorService = manageVendorService;
        this.vendorProductService = vendorProductService;
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

    @PostMapping(value = "/vendors")
    public void addVendor(@RequestBody Vendor vendor) {
        manageVendorService.addVendor(vendor);
    }

    @PutMapping("/vendors")
    public void editVendor(@RequestBody VendorLogged vendor) {
        manageVendorService.editVendor(vendor);
    }

    @DeleteMapping(value = "/vendors")
    public void deleteVendor(@RequestBody Vendor vendor) {
        vendorProductService.deleteVendor(vendor.getId(), vendor.getPassword());
    }
}
