package com.zenjava.community.service.impl.builder;

import com.zenjava.community.service.data.UserRef;
import com.zenjava.community.service.impl.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserRefBuilder extends AbstractBuilder<User, UserRef> {

    @Override
    protected UserRef buildBean(User entity) {
        return new UserRef(
                entity.getId(),
        		entity.getUsername(),
        		entity.getFirstName(),
        		entity.getLastName()
        );
    }
}
