package com.zenjava.community.service.impl.builder;

import com.zenjava.community.service.data.RoleDetail;
import com.zenjava.community.service.impl.entity.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleDetailBuilder extends AbstractBuilder<Role, RoleDetail> {

    @Override
    protected RoleDetail buildBean(Role entity) {
        return new RoleDetail(
                entity.getId(),
        		entity.getName(),
                entity.getDescription()
        );
    }
}
