package com.zenjava.community.service.impl.repository;


import com.zenjava.community.service.impl.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByName(String name);
}

