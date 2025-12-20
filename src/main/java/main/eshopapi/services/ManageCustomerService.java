package main.eshopapi.services;

import main.eshopapi.dtos.CustomerLogged;
import main.eshopapi.entities.Customer;
import main.eshopapi.entities.Vendor;
import main.eshopapi.repositories.ICustomerRepository;
import main.eshopapi.repositories.IVendorRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static java.lang.Math.max;
import static main.eshopapi.services.HashingService.hashPassword;

@Service
public class ManageCustomerService {

    private final ICustomerRepository customerRepository;

    public ManageCustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findCustomerById(Long id) {
        return customerRepository.findCustomerById(id);
    }

    public List<Customer> findCustomersByName(String name) {
        return customerRepository.findCustomersByName(name);
    }

    public Customer findCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }

    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer.getName(), customer.getEmail(), hashPassword(customer.getPassword()));
    }

    public void editCustomer(CustomerLogged customer) {
        if (new BCryptPasswordEncoder().matches(customer.getAuthPassword(),
                customerRepository.findCustomerById(customer.getId()).getPassword())) {
            if (customer.getName() != null) {
                customerRepository.setCustomerName(customer.getId(), customer.getName());
            }

            if (customer.getWallet() != null) {
                customerRepository.setCustomerWallet(customer.getId(), customer.getWallet());
            }

            if (customer.getEmail() != null) {
                customerRepository.setCustomerEmail(customer.getId(), customer.getEmail());
            }

            if (customer.getPassword() != null) {
                customerRepository.setCustomerPassword(customer.getId(), customer.getPassword());
            }
        }


    }

    public void deleteCustomer(CustomerLogged c) {
        if (new BCryptPasswordEncoder().matches(c.getAuthPassword(), customerRepository.findCustomerById(c.getId()).getPassword())) {
            customerRepository.deleteCustomer(c.getId());
        }

    }

    public void editWallet(Long id, BigDecimal amount) {
        BigDecimal new_amount = new BigDecimal(0.0).max(customerRepository.findCustomerById(id).getWallet().add(amount));
        customerRepository.setCustomerWallet(id, new_amount);
    }
}
