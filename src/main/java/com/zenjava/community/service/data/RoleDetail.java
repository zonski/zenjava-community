package com.zenjava.community.service.data;

public class RoleDetail extends RoleSnapshot {

    private String description;

    public RoleDetail(Long id, String name, String description) {
        super(id, name);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
