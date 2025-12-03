package main.eshopapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "vendor")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vendor_id")
    private Long id;

    @Column(name = "vendor_name")
    private String name;

    @Column(name = "vendor_email", unique = true)
    private String email;

    @Column(name = "vendor_password")
    private String password;

    @Column(name = "vendor_wallet")
    private BigDecimal wallet = new BigDecimal(0);
}
