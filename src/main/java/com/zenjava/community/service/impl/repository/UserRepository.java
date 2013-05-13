package com.zenjava.community.service.impl.repository;


import com.zenjava.community.service.impl.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User findByActivationCode(String activationCode);
}

