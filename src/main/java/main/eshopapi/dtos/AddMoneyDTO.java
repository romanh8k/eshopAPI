package main.eshopapi.dtos;

import lombok.Getter;
import lombok.Setter;
import main.eshopapi.enums.UserRoles;

import java.math.BigDecimal;

@Getter
@Setter
public class AddMoneyDTO {

    private Long id;
    private BigDecimal amount;
    private UserRoles role;
}
