package com.zenjava.community.service.impl.security;

import com.zenjava.community.service.data.UserDetail;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUserDetails extends User {

    private UserDetail user;

    public CustomUserDetails(UserDetail user, String password, Collection<GrantedAuthority> authorities) {
        super(user.getUsername(), password, user.isActivated(), true, true, true, authorities);
        this.user = user;
    }

    public String getDisplayName() {
        return user.getFirstName();
    }

    public UserDetail getUser() {
        return user;
    }
}
