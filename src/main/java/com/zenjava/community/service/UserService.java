package com.zenjava.community.service;

import com.zenjava.community.service.data.*;

import java.util.List;

public interface UserService {

    UserDetail getCurrentUser();

    UserDetail findUser(long id);

    UserDetail findUser(String username);

    List<UserSnapshot> findAllUsers();

    RoleDetail findRole(long id);

    List<RoleSnapshot> findAllRoles();

    UserSnapshot signUpUser(SignUpRequest request);

    UserSnapshot activateUserAccount(String activationCode);

    Boolean isUsernameAvailable(String username);
}
