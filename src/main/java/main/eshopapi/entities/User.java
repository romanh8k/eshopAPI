package main.eshopapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public abstract class User {

    private final int id;
    private String name;
    private String mail;
    private BigDecimal wallet;
}
