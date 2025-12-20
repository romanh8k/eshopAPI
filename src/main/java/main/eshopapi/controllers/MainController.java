package main.eshopapi.controllers;

import main.eshopapi.dtos.AddMoneyDTO;
import main.eshopapi.enums.UserRoles;
import main.eshopapi.repositories.ICustomerRepository;
import main.eshopapi.repositories.IVendorRepository;
import main.eshopapi.services.ManageCustomerService;
import main.eshopapi.services.ManageProductService;
import main.eshopapi.services.ManageVendorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private ManageVendorService manageVendorService;
    private ManageCustomerService manageCustomerService;

    public MainController(ManageVendorService manageVendorService, ManageCustomerService manageCustomerService) {
        this.manageVendorService = manageVendorService;
        this.manageCustomerService = manageCustomerService;
    }

    @PostMapping("/addmoney")
    public void addMoney(AddMoneyDTO money) {
        if (money.getRole() == UserRoles.VENDOR) {
            manageVendorService.addMoney(money.getId(), money.getAmount());
        }
        else {
            manageCustomerService.addMoney(money.getId(), money.getAmount());
        }
    }
}
