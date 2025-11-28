package main.eshopapi.repositories;

import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import main.eshopapi.entities.Product;
import main.eshopapi.entities.Vendor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

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

    @Query("select p from Product p where p.vendorId = :id")
    List<Product> findProductsByVendorId(Long id);

    @Query("select p from Product p where p.price >= :price")
    List<Product> findProductsByMorePrice(double price);

    @Query("select p from Product p where p.price <= :price")
    List<Product> findProductsByLessPrice(double price);

    @Query("select p from Product p where p.price >= :lowerBound and p.price <= :upperBound")
    List<Product> findProductsInPriceInterval(double lowerBound, double upperBound);

    @Query("select p from Product p where p.price >= :lowerBound and p.price <= :upperBound and p.name like :name")
    List<Product> findProductsByNameInPriceInterval(String name, double lowerBound, double upperBound);

    @Modifying
    @Query("insert into Product (vendorId, name, description, price, amount) values (:v, :n, :d, :p, :a)")
    @Transactional
    void addProduct(Long v, String n, String d, double p, int a);

    @Modifying
    @Query("update Product p set p.name = :name where p.id = :id")
    @Transactional
    void editProductName(Long id, String name);

    @Modifying
    @Query("update Product p set p.description = :description where p.id = :id")
    @Transactional
    void editProductDescription(Long id, String description);

    @Modifying
    @Query("update Product p set p.price = :price where p.id = :id")
    @Transactional
    void editProductPrice(Long id, double price);

    @Modifying
    @Query("update Product p set p.amount = :amount where p.id = :id")
    @Transactional
    void editProductAmount(Long id, int amount);

    @Modifying
    @Query("delete Product p where p.id = :id")
    @Transactional
    void deleteProductById(int id);

    @Modifying
    @Query("delete Product p where p.vendorId = :id")
    @Transactional
    void deleteProductsByVendorId(int id);
}
