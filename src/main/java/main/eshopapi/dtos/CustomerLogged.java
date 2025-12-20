package main.eshopapi.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CustomerLogged {

    private Long id;
    private String name;
    private String email;
    private String password;
    private BigDecimal wallet;

    private String authPassword;
}
