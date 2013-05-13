package com.zenjava.community.service.data;

public class SystemInfoDetail extends AbstractIdentifiableBean<Long> {

    private String name;
    private String description;
    private String baseUrl;

    public SystemInfoDetail(Long id, String name, String description, String baseUrl) {
        super(id);
        this.name = name;
        this.description = description;
        this.baseUrl = baseUrl;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
