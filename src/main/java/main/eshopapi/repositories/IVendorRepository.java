package main.eshopapi.repositories;

import main.eshopapi.entities.Vendor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVendorRepository extends CrudRepository<Vendor, Long> {


}
