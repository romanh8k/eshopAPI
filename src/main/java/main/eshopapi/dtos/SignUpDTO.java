package main.eshopapi.dtos;

import lombok.Getter;
import lombok.Setter;
import main.eshopapi.enums.UserRoles;

import java.math.BigDecimal;

@Getter
@Setter
public class SignUpDTO {

    private String name;
    private String email;
    private String password;
//    private BigDecimal wallet;
    private UserRoles role;
}
