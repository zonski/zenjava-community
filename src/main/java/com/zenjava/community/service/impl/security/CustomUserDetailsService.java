package com.zenjava.community.service.impl.security;

import com.zenjava.community.service.impl.builder.UserDetailBuilder;
import com.zenjava.community.service.impl.entity.Role;
import com.zenjava.community.service.impl.entity.User;
import com.zenjava.community.service.impl.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailBuilder userDetailBuilder;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

        log.debug("Loading user details for user {}", username);
        User user = userRepository.findByUsername(username);
        if (user == null) {
            log.debug("No user found for username '{}'", username);
            throw new UsernameNotFoundException("No user found for username '" + username + "'");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : user.getRoles()) {
            log.debug("User '{}' has role '{}'", username, role.getName());
            if (role.getPermissions() != null) {
                for (String permission : role.getPermissions()) {
                    authorities.add(new SimpleGrantedAuthority(permission));
                }
            }
        }
        log.debug("User '{}' has {} permissions in total", username, authorities.size());

        return new CustomUserDetails(
            userDetailBuilder.build(user), user.getPassword(), authorities
        );
    }
}
