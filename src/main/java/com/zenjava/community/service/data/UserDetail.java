package com.zenjava.community.service.data;

import java.util.List;

public class UserDetail extends UserRef {

    private List<RoleRef> roles;

    public UserDetail(Long id, String username, String firstName, String lastName, List<RoleRef> roles) {
        super(id, username, firstName, lastName);
        this.roles = roles;
    }

    public List<RoleRef> getRoles() {
        return roles;
    }
}
