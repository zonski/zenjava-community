package com.zenjava.community.service.impl;

import com.zenjava.community.service.SystemService;
import com.zenjava.community.service.data.Permission;
import com.zenjava.community.service.data.SystemInfoDetail;
import com.zenjava.community.service.data.SystemSetupRequest;
import com.zenjava.community.service.data.exception.SystemNotSetupException;
import com.zenjava.community.service.impl.builder.SystemInfoDetailBuilder;
import com.zenjava.community.service.impl.builder.UserDetailBuilder;
import com.zenjava.community.service.impl.entity.Role;
import com.zenjava.community.service.impl.entity.SystemInfo;
import com.zenjava.community.service.impl.entity.User;
import com.zenjava.community.service.impl.helper.SystemInfoHelper;
import com.zenjava.community.service.impl.repository.RoleRepository;
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
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class SystemServiceImpl implements SystemService {

    private static final Logger log = LoggerFactory.getLogger(SystemServiceImpl.class);

    @Autowired private SystemInfoHelper systemInfoHelper;

    @Autowired private UserRepository userRepository;
    @Autowired private RoleRepository roleRepository;

    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private SaltSource saltSource;

    @Autowired private UserDetailBuilder userDetailBuilder;
    @Autowired private SystemInfoDetailBuilder systemInfoDetailBuilder;

    @Transactional(readOnly = false)
    public void setupSystem(SystemSetupRequest request) {

        log.info("Setting up system");

        // 'admin' role

        Role adminRole = new Role("admin", "Administrator role", false, new HashSet<>(
                Arrays.asList(Permission.ALL_PERMISSIONS)));
        roleRepository.save(adminRole);
        log.info("'{}' role created", adminRole.getName());


        // 'user' role

        Role userRole = new Role("user", "User role", true, new HashSet<String>());
        Set<String> userPermissions = new HashSet<>(Arrays.asList(
                Permission.USER_VIEW_OWN
        ));
        userRole.setPermissions(userPermissions);
        roleRepository.save(userRole);
        log.info("'{}' role created", userRole.getName());


        // 'admin' user

        User admin = new User("admin", true, "admin@zenjava.com", "Admin", "User", Arrays.asList(adminRole));
        admin.setPassword(passwordEncoder.encodePassword("password", saltSource.getSalt(
                new CustomUserDetails(userDetailBuilder.build(admin), "password", new ArrayList<GrantedAuthority>()))));
        userRepository.save(admin);
        log.info("User '{}' created with password '{}'", admin.getUsername(), admin.getPassword());

        // 'danz' user

        User danz = new User("danz", true, "zonski@gmail.com", "Dan", "Zwolenski", Arrays.asList(userRole));
        danz.setPassword(passwordEncoder.encodePassword("password", saltSource.getSalt(
                new CustomUserDetails(userDetailBuilder.build(danz), "password", new ArrayList<GrantedAuthority>()))));
        userRepository.save(danz);
        log.info("User '{}' created with password '{}'", danz.getUsername(), danz.getPassword());


        // save setup details
        SystemInfo systemInfo = new SystemInfo(
                request.getName(), request.getDescription(), request.getBaseUrl(),
                request.getEmailServer(), request.getEmailPort(), request.getEmailUsername(), request.getEmailPassword());
        systemInfoHelper.saveSystemInfo(systemInfo);

        log.info("Done setting up system");
    }

    @Override
    public SystemInfoDetail getSystemInfo() throws SystemNotSetupException {
        return systemInfoDetailBuilder.build(systemInfoHelper.getSystemInfo());
    }
}
