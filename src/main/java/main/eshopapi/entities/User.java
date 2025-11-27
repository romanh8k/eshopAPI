package main.eshopapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public abstract class User {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String mail;
    private BigDecimal wallet;
}
