package com.examples.bootportal.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class LoginUser extends User {
    private String name;
    private Long id;

    public LoginUser (String email, String password, Collection<? extends GrantedAuthority> authorities) {
        super(email, password, true, true, true, true, authorities);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
