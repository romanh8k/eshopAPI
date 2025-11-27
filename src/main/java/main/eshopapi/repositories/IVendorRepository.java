package main.eshopapi.repositories;

import main.eshopapi.entities.Product;
import main.eshopapi.entities.Vendor;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVendorRepository extends CrudRepository<Vendor, Long> {

    @Query("select * from vendor where name = :name")
    List<Vendor> findVendorsByName(String name);

    Vendor findVendorById(Long id);
}
