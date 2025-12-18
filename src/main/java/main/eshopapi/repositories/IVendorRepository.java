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

    @Query("select v from Vendor v where v.email = :email")
    Vendor findVendorByEmail(String email);

    @Modifying
    @Query(value = "insert into vendor (vendor_name, vendor_email, vendor_password, vendor_wallet) values (:name, :email, :password, 0.0)", nativeQuery = true)
    @Transactional
    void addVendor(String name, String email, String password);

    @Modifying
    @Query(value = "update vendor set vendor_name = :name where vendor_id = :id", nativeQuery = true)
    @Transactional
    void setVendorName(Long id, String name);

    @Modifying
    @Query(value = "update vendor set vendor_wallet = :wallet where vendor_id = :id", nativeQuery = true)
    @Transactional
    void setVendorWallet(Long id, BigDecimal wallet);

    @Modifying
    @Query(value = "update vendor set vendor_email = :email where vendor_id = :id", nativeQuery = true)
    @Transactional
    void setVendorEmail(Long id, String email);

    @Modifying
    @Query(value = "update vendor set vendor_password = :password where vendor_id = :id", nativeQuery = true)
    @Transactional
    void setVendorPassword(Long id, String password);

    @Modifying
    @Query("delete from Vendor v where v.id = :id")
    @Transactional
    void deleteVendor(Long id);
}
