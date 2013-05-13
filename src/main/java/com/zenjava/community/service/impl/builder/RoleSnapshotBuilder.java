package com.zenjava.community.service.impl.builder;

import com.zenjava.community.service.data.RoleSnapshot;
import com.zenjava.community.service.impl.entity.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleSnapshotBuilder extends AbstractBuilder<Role, RoleSnapshot> {

    @Override
    protected RoleSnapshot buildBean(Role entity) {
        return new RoleSnapshot(
                entity.getId(),
        		entity.getName()
        );
    }
}
