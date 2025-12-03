package main.eshopapi.dtos;

import lombok.Getter;
import lombok.Setter;
import main.eshopapi.enums.UserRoles;

import java.math.BigDecimal;

@Getter
@Setter
public class UserDTO {

    private String name;
    private String email;
    private BigDecimal wallet;
    private UserRoles role;
}
