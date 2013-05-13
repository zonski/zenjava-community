package com.zenjava.community.service.impl.builder;

import com.zenjava.community.service.data.UserDetail;
import com.zenjava.community.service.impl.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailBuilder extends AbstractBuilder<User, UserDetail> {

    @Autowired
    private RoleSnapshotBuilder roleSnapshotBuilder;

    @Override
    protected UserDetail buildBean(User entity) {
        return new UserDetail(
                entity.getId(),
        		entity.getUsername(),
        		entity.getFirstName(),
        		entity.getLastName(),
                entity.isActivated(),
                roleSnapshotBuilder.build(entity.getRoles())
        );
    }
}
