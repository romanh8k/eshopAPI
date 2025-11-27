package main.eshopapi.repositories;

import jakarta.persistence.Entity;
import main.eshopapi.entities.Product;
import main.eshopapi.entities.Vendor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IProductRepository extends CrudRepository<Product, Long> {

    @Query("select n from Product n where n.name = :name")
    List<Product> findProductsByName(String name);

    Product findProductById(Long id);

    @Query("insert into Product (vendorId, name, description, price, amount) values (:v, :n, :d, :p, :a)")
    void addProduct(long v, String n, String d, double p, int a);
}
