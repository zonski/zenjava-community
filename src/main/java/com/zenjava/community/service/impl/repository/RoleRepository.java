package com.zenjava.community.service.impl.repository;


import com.zenjava.community.service.impl.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByName(String name);

    List<Role> findByAutoAssign(boolean autoAssign);
}

