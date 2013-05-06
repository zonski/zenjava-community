package com.zenjava.community.service.impl;

import com.zenjava.community.service.SystemService;
import com.zenjava.community.service.data.Permission;
import com.zenjava.community.service.data.SystemInfoDetail;
import com.zenjava.community.service.data.SystemSetupRequest;
import com.zenjava.community.service.impl.builder.SystemInfoDetailBuilder;
import com.zenjava.community.service.impl.builder.UserDetailBuilder;
import com.zenjava.community.service.impl.entity.Role;
import com.zenjava.community.service.impl.entity.SystemInfo;
import com.zenjava.community.service.impl.entity.User;
import com.zenjava.community.service.impl.repository.RoleRepository;
import com.zenjava.community.service.impl.repository.SystemInfoRepository;
import com.zenjava.community.service.impl.repository.UserRepository;
import com.zenjava.community.service.impl.security.CustomUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

@Service
@Transactional(readOnly = true)
public class SystemServiceImpl implements SystemService {

    private static final Logger log = LoggerFactory.getLogger(SystemServiceImpl.class);

    @Autowired private UserRepository userRepository;
    @Autowired private RoleRepository roleRepository;
    @Autowired private SystemInfoRepository systemInfoRepository;

    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private SaltSource saltSource;

    @Autowired private UserDetailBuilder userDetailBuilder;
    @Autowired private SystemInfoDetailBuilder systemInfoDetailBuilder;

    @Transactional(readOnly = false)
    public void setupSystem(SystemSetupRequest request) {

        log.info("Setting up system");

        // 'admin' role

        Role adminRole = new Role("admin", "Administrator role", new HashSet<>(
                Arrays.asList(Permission.ALL_PERMISSIONS)));
        roleRepository.save(adminRole);
        log.info("'{}' role created", adminRole.getName());


        // 'user' role

        Role userRole = new Role("user", "User role", new HashSet<String>());
        // todo add user permissions
        roleRepository.save(userRole);
        log.info("'{}' role created", userRole.getName());


        // 'admin' user

        User admin = new User("admin", "Admin", "User", adminRole);
        admin.setPassword(passwordEncoder.encodePassword("password", saltSource.getSalt(
                new CustomUserDetails(userDetailBuilder.build(admin), "password", new ArrayList<GrantedAuthority>()))));
        userRepository.save(admin);
        log.info("User '{}' created with password '{}'", admin.getUsername(), admin.getPassword());

        // 'danz' user

        User danz = new User("danz", "Dan", "Zwolenski", userRole);
        danz.setPassword(passwordEncoder.encodePassword("password", saltSource.getSalt(
                new CustomUserDetails(userDetailBuilder.build(danz), "password", new ArrayList<GrantedAuthority>()))));
        userRepository.save(danz);
        log.info("User '{}' created with password '{}'", danz.getUsername(), danz.getPassword());


        // save setup details
        SystemInfo systemInfo = new SystemInfo(request.getName(), request.getDescription());
        systemInfoRepository.save(systemInfo);

        log.info("Done setting up system");
    }

    @Override
    public SystemInfoDetail getSystemInfo() {
        Iterator<SystemInfo> all = systemInfoRepository.findAll().iterator();
        if (all.hasNext()) {
            SystemInfo systemInfo = all.next();
            log.debug("Found system information '{}'", systemInfo.getName());
            return systemInfoDetailBuilder.build(systemInfo);
        } else {
            log.debug("System is not yet setup, no info available");
            return null;
        }
    }
}