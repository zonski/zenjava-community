package com.zenjava.community.service.data;

import java.io.Serializable;

public abstract class AbstractIdentifiableBean<IdType extends Serializable> implements Serializable {

    private IdType id;

    public AbstractIdentifiableBean() {
    }

    public AbstractIdentifiableBean(IdType id) {
        this.id = id;
    }

    public IdType getId() {
        return id;
    }
}
