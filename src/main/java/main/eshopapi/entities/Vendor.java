package main.eshopapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
public class Vendor {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private BigDecimal wallet;
    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;

    public Vendor() {
        super();
        products = new ArrayList<Product>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> findProductsByName(String name) {
        List<Product> ps = products.stream()
                .filter(p -> Objects.equals(p.getName(), name))
                .collect(Collectors.toList());
        return ps;
    }

    public List<Product> findProductsByPrice(double price) {
        List<Product> ps = products.stream()
                .filter(p -> Objects.equals(p.getPrice(), price))
                .collect(Collectors.toList());
        return ps;
    }

    public void removeProduct(Product p) {
        products.remove(p);
    }
}
