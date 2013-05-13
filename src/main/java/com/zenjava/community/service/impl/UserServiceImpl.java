package com.zenjava.community.service.impl;

import com.zenjava.community.service.UserService;
import com.zenjava.community.service.data.*;
import com.zenjava.community.service.impl.builder.RoleDetailBuilder;
import com.zenjava.community.service.impl.builder.RoleSnapshotBuilder;
import com.zenjava.community.service.impl.builder.UserDetailBuilder;
import com.zenjava.community.service.impl.builder.UserSnapshotBuilder;
import com.zenjava.community.service.impl.entity.Role;
import com.zenjava.community.service.impl.entity.User;
import com.zenjava.community.service.impl.helper.EmailHelper;
import com.zenjava.community.service.impl.helper.SystemInfoHelper;
import com.zenjava.community.service.impl.repository.RoleRepository;
import com.zenjava.community.service.impl.repository.UserRepository;
import com.zenjava.community.service.impl.security.CustomUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired private UserRepository  userRepository;
    @Autowired private UserDetailBuilder userDetailBuilder;
    @Autowired private UserSnapshotBuilder userSnapshotBuilder;

    @Autowired private RoleRepository roleRepository;
    @Autowired private RoleDetailBuilder roleDetailBuilder;
    @Autowired private RoleSnapshotBuilder roleSnapshotBuilder;

    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private SaltSource saltSource;
    @Autowired private EmailHelper emailHelper;
    @Autowired private SystemInfoHelper systemInfoHelper;

    @Override
    @Secured(Permission.USER_VIEW_OWN)
    public UserDetail getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ((CustomUserDetails)authentication.getPrincipal()).getUser();
    }

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
    public List<UserSnapshot> findAllUsers() {
        log.debug("Finding all user details");
        Iterable<User> users = userRepository.findAll();
        return userSnapshotBuilder.build(users);
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
    public List<RoleSnapshot> findAllRoles() {
        log.debug("Finding all role details");
        Iterable<Role> roles = roleRepository.findAll();
        return roleSnapshotBuilder.build(roles);
    }

    @Override
    @Transactional(readOnly = false)
    public UserSnapshot signUpUser(SignUpRequest request) {

        log.info("Signing up new user: '{}' ({})", request.getUsername(), request.getEmail());

        List<Role> roles = roleRepository.findByAutoAssign(true);
        User user = new User(request.getUsername(), false, request.getEmail(), request.getFirstName(), request.getLastName(), roles);

        // create temp details for use with salt generator
        CustomUserDetails userDetails = new CustomUserDetails(userDetailBuilder.build(user), request.getPassword(), new ArrayList<GrantedAuthority>());

        user.setPassword(passwordEncoder.encodePassword(request.getPassword(), saltSource.getSalt(userDetails)));
        user.setActivationCode(passwordEncoder.encodePassword(request.getUsername(), saltSource.getSalt(userDetails)));

        userRepository.save(user);

        sendConfirmationEmail(user);

        return userSnapshotBuilder.build(user);
    }

    @Override
    @Transactional(readOnly = false)
    public UserSnapshot activateUserAccount(String activationCode) {
        User user = userRepository.findByActivationCode(activationCode);
        log.info("Activating user account for '{}', with code: '{}'", user.getUsername(), activationCode);
        user.setActivated(true);
        user.setActivationCode(null);
        userRepository.save(user);
        return userSnapshotBuilder.build(user);
    }

    private void sendConfirmationEmail(final User user) {
        log.info("Sending signup confirmation email to: '{}'", user.getUsername());

        String activationUrl = systemInfoHelper.buildUrl("/activate/" + user.getActivationCode());

        // todo use templating engine to build email body

        emailHelper.sendEmail(user.getEmail(), "Welcome to ", "Activation URL: " + activationUrl);
    }
}
