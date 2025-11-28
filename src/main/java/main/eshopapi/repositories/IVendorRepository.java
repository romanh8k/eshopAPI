package main.eshopapi.repositories;

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
public interface IVendorRepository extends CrudRepository<Vendor, Long> {

    @Query("select v from Vendor v where v.name = :name")
    List<Vendor> findVendorsByName(String name);

    Vendor findVendorById(Long id);

    @Query("select v from Vendor v")
    List<Vendor> findAll();

    @Modifying
    @Query(value = "insert into vendor (vendor_name) values (:name)", nativeQuery = true)
    @Transactional
    void addVendor(String name);
}
