package main.eshopapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
//    @Getter
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "vendor_id")
    @Column(name = "vendor_id")
    private Long vendorId;

    @Column(name = "product_name")
//    @Getter
    private String name;

    @Column(name = "product_description")
//    @Getter
    private String description;

    @Column(name = "product_price")
//    @Getter
    private double price;

    @Column(name = "product_amount")
//    @Getter
    private int amount;

//    public Long getVendorId() {
//        return vendorId.getId();
//    }
}