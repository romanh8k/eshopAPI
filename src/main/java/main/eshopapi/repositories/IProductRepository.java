package main.eshopapi.repositories;

import main.eshopapi.entities.Product;
import main.eshopapi.entities.Vendor;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface IProductRepository extends CrudRepository<Product, Long> {

    @Query("select * from product where name = :name")
    List<Product> findProductsByName(String name);

    Product findProductById(Long id);

    @Query("insert into product (vendor, name, description, price, amount) values (:v, :n, :d, :p, :a)")
    void addProduct(Vendor v, String n, String d, double p, int a);
}
