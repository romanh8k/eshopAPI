package main.eshopapi.repositories;

import jakarta.transaction.Transactional;
import main.eshopapi.entities.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Long> {

    @Query("select c from Customer c where c.name = :name")
    List<Customer> findCustomersByName(String name);

    Customer findCustomerById(Long id);

    @Query("select c from Customer c where c.email = :email")
    Customer findCustomerByEmail(String email);

    @Query("select c from Customer c")
    List<Customer> findAll();

    @Modifying
    @Query(value = "insert into customer (customer_name, customer_email, customer_wallet) values (:name, :email, 0.0)", nativeQuery = true)
    @Transactional
    void addCustomer(String name, String email);

    @Modifying
    @Query(value = "update customer set customer_name = :name where customer_id = :id", nativeQuery = true)
    @Transactional
    void setCustomerName(Long id, String name);

    @Modifying
    @Query(value = "update customer set customer_wallet = :wallet where customer_id = :id", nativeQuery = true)
    @Transactional
    void setCustomerWallet(Long id, BigDecimal wallet);

    @Modifying
    @Query("delete from Customer c where c.id = :id")
    @Transactional
    void deleteCustomer(Long id);
}
