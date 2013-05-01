package com.zenjava.community.service.impl.builder;

import com.zenjava.community.service.data.RoleRef;
import com.zenjava.community.service.impl.entity.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleRefBuilder extends AbstractBuilder<Role, RoleRef> {

    @Override
    protected RoleRef buildBean(Role entity) {
        return new RoleRef(
                entity.getId(),
        		entity.getName()
        );
    }
}
