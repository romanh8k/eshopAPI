package main.eshopapi.services;

import main.eshopapi.entities.Customer;
import main.eshopapi.entities.Vendor;
import main.eshopapi.repositories.ICustomerRepository;
import main.eshopapi.repositories.IVendorRepository;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class SignUpService {

    private ManageVendorService manageVendorService;
    private ManageCustomerService manageCustomerService;

    private Logger logger = Logger.getLogger(SignUpService.class.getName());

    public SignUpService(ManageCustomerService manageCustomerService, ManageVendorService manageVendorService) {
        this.manageCustomerService = manageCustomerService;
        this.manageVendorService = manageVendorService;
    }

    public boolean signUp(Vendor vendor) {
        if (manageVendorService.findVendorByEmail(vendor.getEmail()) == null) {
            logger.info("New vendor added!");
            manageVendorService.addVendor(vendor);
            return true;
        }
        else {
            logger.warning("Vendor with this email " + vendor.getEmail() + " already exists!");
            return false;
        }
    }

    public boolean signUp(Customer customer) {
        if (manageCustomerService.findCustomerByEmail(customer.getEmail()) == null) {
            logger.info("New customer added!");
            manageCustomerService.addCustomer(customer);
            return true;
        }
        else {
            logger.warning("Customer with this email " + customer.getEmail() + " already exists!");
            return false;
        }
    }
}
