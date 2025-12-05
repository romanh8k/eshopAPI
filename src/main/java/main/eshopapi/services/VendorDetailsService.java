package main.eshopapi.services;

import main.eshopapi.entities.Vendor;
import main.eshopapi.userdetails.VendorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class VendorDetailsService implements UserDetailsService {

    @Autowired
    private ManageVendorService manageVendorService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Vendor vendor = manageVendorService.findVendorByEmail(email);
        if (vendor == null) {
            throw  new UsernameNotFoundException("Vendor not found!");
        }
        return new VendorDetails(vendor);
    }
}
