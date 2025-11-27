package main.eshopapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {

    private Vendor vendor;
    private String name;
    private String description;
    private double price;
}