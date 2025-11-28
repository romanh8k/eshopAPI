package main.eshopapi.repositories;

import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import main.eshopapi.entities.Product;
import main.eshopapi.entities.Vendor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IProductRepository extends CrudRepository<Product, Long> {

    @Query("select p from Product p where p.name = :name")
    List<Product> findProductsByName(String name);

    Product findProductById(Long id);

    @Query("select p from Product p")
    List<Product> findAll();

    @Query("select p from Product p where p.price = :price")
    List<Product> findProductsByPrice(double price);

    @Modifying
    @Query("insert into Product (vendorId, name, description, price, amount) values (:v, :n, :d, :p, :a)")
    @Transactional
    void addProduct(Long v, String n, String d, double p, int a);
}
