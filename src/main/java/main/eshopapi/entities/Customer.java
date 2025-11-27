package main.eshopapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String mail;
    private BigDecimal wallet;
}
