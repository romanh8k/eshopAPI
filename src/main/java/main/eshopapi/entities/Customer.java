package main.eshopapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_email", unique = true)
    private String email;

    @Column(name = "customer_wallet")
    private BigDecimal wallet;
}
