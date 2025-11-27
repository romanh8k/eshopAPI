package main.eshopapi.entities;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
public class Vendor extends User {

    private List<Product> products;

    public Vendor(int id, String name, String mail) {
        super(id, name, mail, new BigDecimal(0));
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
