//package main.eshopapi.services;
//
//import main.eshopapi.entities.Vendor;
//import main.eshopapi.userdetails.VendorDetails;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.logging.Logger;
//
//@Service
//public class VendorDetailsService implements UserDetailsService {
//
//    private Logger logger = Logger.getLogger(VendorDetailsService.class.getName());
//
//    @Autowired
//    private ManageVendorService manageVendorService;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Vendor vendor = manageVendorService.findVendorByEmail(email);
//        if (vendor == null) {
//            throw new UsernameNotFoundException("Vendor not found!");
//        }
//        logger.info(vendor.getEmail() + " " + vendor.getPassword());
////        Vendor v = new Vendor();
////        v.setEmail(vendor.getEmail());
////        v.setPassword(vendor.getPassword());
////        return new
//        return new VendorDetails(vendor);
//    }
//
//
//}
