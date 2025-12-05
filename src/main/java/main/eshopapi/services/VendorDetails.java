package main.eshopapi.services;

import main.eshopapi.entities.Vendor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class VendorDetails implements UserDetails {

    private Vendor vendor;

    public VendorDetails(Vendor vendor) {
        this.vendor = vendor;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public @Nullable String getPassword() {
        return vendor.getPassword();
    }

    @Override
    public String getUsername() {
        return vendor.getEmail();
    }
}
