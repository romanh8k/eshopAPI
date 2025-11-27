package main.eshopapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {

    @Id
    private int id;
    private Vendor vendor;
    private String name;
    private String description;
    private double price;
}