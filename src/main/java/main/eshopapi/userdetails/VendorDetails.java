//package main.eshopapi.userdetails;
//
//import main.eshopapi.entities.Vendor;
//import org.jspecify.annotations.Nullable;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//
//public class VendorDetails implements UserDetails {
//
//    private Vendor vendor;
//
//    public VendorDetails(Vendor vendor) {
//        this.vendor = vendor;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(new SimpleGrantedAuthority("USER"));
//    }
//
//    @Override
//    public @Nullable String getPassword() {
//        return vendor.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return vendor.getEmail();
//    }
//}
