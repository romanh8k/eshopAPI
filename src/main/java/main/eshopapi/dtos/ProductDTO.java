package main.eshopapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private Long vendorId;
    private String name;
    private String description;
    private double price;
    private int amount;
}
