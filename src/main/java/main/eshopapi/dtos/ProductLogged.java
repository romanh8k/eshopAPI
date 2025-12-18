package main.eshopapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductLogged {

    private Long id;
    private String name;
    private String description;
    private double price;
    private int amount;
    private Long vendorId;

    private String vendorPassword;
}
