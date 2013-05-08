package com.zenjava.community.service.impl;

import com.zenjava.community.service.UserService;
import com.zenjava.community.service.data.*;
import com.zenjava.community.service.impl.builder.RoleDetailBuilder;
import com.zenjava.community.service.impl.builder.RoleRefBuilder;
import com.zenjava.community.service.impl.builder.UserDetailBuilder;
import com.zenjava.community.service.impl.builder.UserRefBuilder;
import com.zenjava.community.service.impl.entity.Role;
import com.zenjava.community.service.impl.entity.User;
import com.zenjava.community.service.impl.repository.RoleRepository;
import com.zenjava.community.service.impl.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired private UserRepository userRepository;
    @Autowired private UserDetailBuilder userDetailBuilder;
    @Autowired private UserRefBuilder userRefBuilder;

    @Autowired private RoleRepository roleRepository;
    @Autowired private RoleDetailBuilder roleDetailBuilder;
    @Autowired private RoleRefBuilder roleRefBuilder;

    @Override
    @Secured(Permission.USER_VIEW_ANY)
    public UserDetail findUser(long id) {
        log.debug("Finding user details for ID {}", id);
        User user = userRepository.findOne(id);
        return userDetailBuilder.build(user);
    }

    @Override
    @Secured(Permission.USER_VIEW_ANY)
    public UserDetail findUser(String username) {
        log.debug("Finding user details for username '{}'", username);
        User user = userRepository.findByUsername(username);
        return userDetailBuilder.build(user);
    }

    @Override
    @Secured(Permission.USER_VIEW_ANY)
    public List<UserRef> findAllUsers() {
        log.debug("Finding all user details");
        Iterable<User> users = userRepository.findAll();
        return userRefBuilder.build(users);
    }

    @Override
    @Secured(Permission.ROLE_VIEW_ANY)
    public RoleDetail findRole(long id) {
        log.debug("Finding role details for ID {}", id);
        Role role = roleRepository.findOne(id);
        return roleDetailBuilder.build(role);
    }

    @Override
    @Secured(Permission.ROLE_VIEW_ANY)
    public List<RoleRef> findAllRoles() {
        log.debug("Finding all role details");
        Iterable<Role> roles = roleRepository.findAll();
        return roleRefBuilder.build(roles);
    }

    @Override
    @Transactional(readOnly = false)
    public UserRef signUpUser(SignUpRequest request) {
        log.info("Signing up new user: '{}' ({})", request.getUsername(), request.getEmail());

        List<Role> roles = new ArrayList<>();

        User user = new User(request.getUsername(), request.getPassword(), request.getEmail(),
                request.getFirstName(), request.getLastName(), roles);
        userRepository.save(user);

        // todo send confirmation email

        return userRefBuilder.build(user);
    }
}
