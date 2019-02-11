package com.estheto.esms.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private String userName;
    private String password;
    private List<GrantedAuthority> auths;

    public CustomUserDetails(User byUsername) {
        this.userName = byUsername.getUsername();
        this.password = byUsername.getPassword();
        auths = new ArrayList<>();
        for(Role role: byUsername.getRoles()) {
            auths.add(new SimpleGrantedAuthority("ROLE_" + role.getValue().toUpperCase()));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.auths;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
