package com.zenjava.community.service;

import com.zenjava.community.service.data.RoleDetail;
import com.zenjava.community.service.data.RoleRef;
import com.zenjava.community.service.data.UserDetail;
import com.zenjava.community.service.data.UserRef;

import java.util.List;

public interface UserService {

    UserDetail findUser(long id);

    UserDetail findUser(String username);

    List<UserRef> findAllUsers();

    RoleDetail findRole(long id);

    List<RoleRef> findAllRoles();
}
