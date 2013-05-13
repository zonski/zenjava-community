package com.zenjava.community.service.data;

import java.util.List;

public class UserDetail extends UserSnapshot {

    private boolean activated;
    private List<RoleSnapshot> roles;

    public UserDetail(Long id, String username, String firstName, String lastName, boolean activated, List<RoleSnapshot> roles) {
        super(id, username, firstName, lastName);
        this.activated = activated;
        this.roles = roles;
    }

    public boolean isActivated() {
        return activated;
    }

    public List<RoleSnapshot> getRoles() {
        return roles;
    }
}
