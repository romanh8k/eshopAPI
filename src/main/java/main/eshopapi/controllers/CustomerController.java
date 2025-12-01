package main.eshopapi.controllers;

import main.eshopapi.entities.Customer;
import main.eshopapi.services.ManageCustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CustomerController {

    private final ManageCustomerService manageCustomerService;

    public CustomerController(ManageCustomerService manageCustomerService) {
        this.manageCustomerService = manageCustomerService;
    }

    @GetMapping(value = "/customers")
    public List<Customer> findAll() {
        return manageCustomerService.findAll();
    }

    @GetMapping(value = "/customers", params = "id")
    public Customer findVendorById(@RequestParam Long id) {
        return manageCustomerService.findCustomerById(id);
    }

    @GetMapping(value = "/customers", params = "name")
    public List<Customer> findCustomersByName(@RequestParam String name) {
        return manageCustomerService.findCustomersByName(name);
    }

    @PostMapping(value = "/customers")
    public void addCustomer(@RequestBody String name) {
        manageCustomerService.addCustomer(name);
    }

    @PutMapping("/customers")
    public void editCustomer(@RequestBody Customer customer) {
        manageCustomerService.editCustomer(customer);
    }

    @DeleteMapping(value = "/customers", params = "id")
    public void deleteCustomer(@RequestParam Long id) {
        manageCustomerService.deleteCustomer(id);
    }
}
