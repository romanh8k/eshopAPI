package main.eshopapi.controllers;

import main.eshopapi.dtos.AddMoneyDTO;
import main.eshopapi.enums.UserRoles;
import main.eshopapi.services.ManageCustomerService;
import main.eshopapi.services.ManageVendorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoneyController {

    private ManageVendorService manageVendorService;
    private ManageCustomerService manageCustomerService;

    public MoneyController(ManageVendorService manageVendorService, ManageCustomerService manageCustomerService) {
        this.manageVendorService = manageVendorService;
        this.manageCustomerService = manageCustomerService;
    }

    @PostMapping("/addmoney")
    public void addMoney(@RequestBody AddMoneyDTO money) {
        if (money.getRole() == UserRoles.VENDOR) {
            manageVendorService.editWallet(money.getId(), money.getAmount());
        }
        else {
            manageCustomerService.editWallet(money.getId(), money.getAmount());
        }
    }
}
