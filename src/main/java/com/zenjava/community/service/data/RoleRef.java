package com.zenjava.community.service.data;

public class RoleRef extends AbstractIdentifiableBean<Long> {

    private String name;

    public RoleRef(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
