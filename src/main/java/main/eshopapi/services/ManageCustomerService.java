package main.eshopapi.services;

import main.eshopapi.entities.Customer;
import main.eshopapi.entities.Vendor;
import main.eshopapi.repositories.ICustomerRepository;
import main.eshopapi.repositories.IVendorRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static java.lang.Math.max;

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
        customerRepository.addCustomer(customer.getName(), customer.getEmail(), customer.getPassword());
    }

    public void editCustomer(Customer customer) {

        if (customer.getName() != null) {
            customerRepository.setCustomerName(customer.getId(), customer.getName());
        }

        if (customer.getWallet() != null) {
            customerRepository.setCustomerWallet(customer.getId(), customer.getWallet());
        }
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteCustomer(id);
    }

    public void editWallet(Long id, BigDecimal amount) {
        BigDecimal new_amount = new BigDecimal(0.0).max(customerRepository.findCustomerById(id).getWallet().add(amount));
        customerRepository.setCustomerWallet(id, new_amount);
    }
}
