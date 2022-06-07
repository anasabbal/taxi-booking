package com.example.taxibooking.payload;

import com.example.taxibooking.model.Account;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


@Getter
@Setter
public class UserDetailsImpl implements UserDetails {

    private String email;
    private String password;
    private GrantedAuthority authorities;

    public UserDetailsImpl(String email, String password, GrantedAuthority authorities) {
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(Account account) {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + account.getUserType().name());
        return new UserDetailsImpl(
                account.getEmail(),
                account.getPassword(),
                authority
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(authorities);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
