package main.eshopapi.controllers;

import main.eshopapi.dtos.CustomerLogged;
import main.eshopapi.entities.Customer;
import main.eshopapi.services.ManageCustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public void addCustomer(@RequestBody Customer customer) {
        manageCustomerService.addCustomer(customer);
    }

    @PutMapping("/customers")
    public void editCustomer(@RequestBody CustomerLogged customer) {
        manageCustomerService.editCustomer(customer);
    }

    @DeleteMapping(value = "/customers")
    public void deleteCustomer(@RequestBody CustomerLogged customer) {
        manageCustomerService.deleteCustomer(customer);
    }
}
