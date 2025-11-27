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
@Table(name="vendor")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vendor_id")
    private Long id;

    @Column(name = "vendor_name")
    private String name;

    @Column(name = "vendor_wallet")
    private BigDecimal wallet;
//    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Long> products;

    public Vendor() {
        super();
//        products = new ArrayList<Long>();
    }

//    public void addProduct(Product p) {
//        products.add(p);
//    }

//    public List<Product> findProductsByName(String name) {
//        List<Product> ps = products.stream()
//                .filter(p -> Objects.equals(p.getName(), name))
//                .collect(Collectors.toList());
//        return ps;
//    }
//
//    public List<Product> findProductsByPrice(double price) {
//        List<Product> ps = products.stream()
//                .filter(p -> Objects.equals(p.getPrice(), price))
//                .collect(Collectors.toList());
//        return ps;
//    }
//
//    public void sellProduct(Product p) {
//        Product remove = products.stream()
//                        .filter(prod -> Objects.equals(prod.getId(), p.getId()))
//                        .findAny().get();
//        if (remove.getAmount() > p.getAmount()) {
//            remove.setAmount(remove.getAmount() - p.getAmount());
//        }
//        else {
//            products.remove(p);
//        }
//
//    }
}
