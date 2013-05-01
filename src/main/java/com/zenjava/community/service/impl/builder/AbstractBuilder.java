package com.zenjava.community.service.impl.builder;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBuilder<EntityType, BeanType> {

    public BeanType build(EntityType entity) {
        if (entity != null) {
            return buildBean(entity);
        } else {
            return null;
        }
    }

    public List<BeanType> build(Iterable<EntityType> entities) {
        if (entities != null) {
            List<BeanType> beans = new ArrayList<>();
            for (EntityType entity : entities) {
                beans.add(build(entity));
            }
            return beans;
        } else {
            return null;
        }
    }

    protected abstract BeanType buildBean(EntityType entity);
}
