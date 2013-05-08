package com.zenjava.community.service;

import com.zenjava.community.service.data.*;

import java.util.List;

public interface UserService {

    UserDetail findUser(long id);

    UserDetail findUser(String username);

    List<UserRef> findAllUsers();

    RoleDetail findRole(long id);

    List<RoleRef> findAllRoles();

    UserRef signUpUser(SignUpRequest request);

}
