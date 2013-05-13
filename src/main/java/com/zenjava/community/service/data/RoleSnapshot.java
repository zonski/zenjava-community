package com.zenjava.community.service.data;

public class RoleSnapshot extends AbstractIdentifiableBean<Long> {

    private String name;

    public RoleSnapshot(Long id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
