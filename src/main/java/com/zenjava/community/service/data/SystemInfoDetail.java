package com.zenjava.community.service.data;

public class SystemInfoDetail extends AbstractIdentifiableBean<Long> {

    private String name;
    private String description;

    public SystemInfoDetail(Long id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
