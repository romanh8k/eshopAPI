package main.eshopapi.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class VendorLogged {

    private Long id;
    private String email;
    private String password;
    private String name;
    private BigDecimal wallet;

    private String authPassword;
}
