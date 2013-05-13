package com.zenjava.community.service.impl.builder;

import com.zenjava.community.service.data.UserSnapshot;
import com.zenjava.community.service.impl.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserSnapshotBuilder extends AbstractBuilder<User, UserSnapshot> {

    @Override
    protected UserSnapshot buildBean(User entity) {
        return new UserSnapshot(
                entity.getId(),
        		entity.getUsername(),
        		entity.getFirstName(),
        		entity.getLastName()
        );
    }
}
