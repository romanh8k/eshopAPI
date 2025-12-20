package main.eshopapi.controllers;

import main.eshopapi.dtos.BuyDTO;
import main.eshopapi.services.BuyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyController {

    private BuyService buyService;

    public BuyController(BuyService buyService) {
        this.buyService = buyService;
    }

    @PostMapping("/buy")
    public void buy(@RequestBody BuyDTO buy) {
        buyService.buyProduct(buy);
    }
}
