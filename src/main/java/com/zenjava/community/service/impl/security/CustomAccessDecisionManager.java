package com.zenjava.community.service.impl.security;

import com.zenjava.community.service.data.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomAccessDecisionManager implements AccessDecisionManager {

    private static final Logger log = LoggerFactory.getLogger(CustomAccessDecisionManager.class);

    public void decide(Authentication authentication, Object object,
                       Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException, InsufficientAuthenticationException {

        if (log.isTraceEnabled()) {
            log.trace("Deciding if {} has permission for target {}, which requires: {}",
                    new Object[]{authentication, object, configAttributes});
        }

        for (ConfigAttribute attribute : configAttributes) {
            String requiredPermission = attribute.getAttribute();
            checkPermission(authentication, requiredPermission);
        }
    }

    public void checkPermission(Authentication authentication, String requiredPermission) {
        if (log.isTraceEnabled()) {
            log.trace("Checking for permission: {}", requiredPermission);
        }
        if (!hasPermission(authentication, requiredPermission)) {
            log.debug("User {} does not have permission {}", authentication.getPrincipal(), requiredPermission);
            throw new AccessDeniedException(String.format("User '%s' does not have permission '%s'",
                    authentication.getPrincipal(), requiredPermission));
        }
    }

    public boolean hasPermission(Authentication authentication, String requiredPermission) {
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            String permission = authority.getAuthority();
            if (permission.equals(requiredPermission) || permission.equals(Permission.ALL_PERMISSIONS)) {
                return true;
            }
        }
        return false;
    }

    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    public boolean supports(Class<?> aClass) {
        return true;
    }
}
