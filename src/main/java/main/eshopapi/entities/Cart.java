package main.eshopapi.entities;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@SessionScope
@Component
public class Cart {

    private List<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addToCart(Product p) {
        products.add(p);
    }

    public void removeFromCart(Product p) {
        products.remove(p);
    }
}
