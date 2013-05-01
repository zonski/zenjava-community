package com.zenjava.community.web.admin;

import com.zenjava.community.service.UserService;
import com.zenjava.community.service.data.UserDetail;
import com.zenjava.community.service.data.UserRef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminUserController {

    private static final Logger log = LoggerFactory.getLogger(AdminUserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/list")
    public String showUserListPage(Model model) {
        log.debug("Finding all users");
        List<UserRef> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "/admin/user/list";
    }

    @RequestMapping(value = "/user/{id}")
    public String showUserListPage(Model model, @PathVariable("id") long id) {
        log.debug("Finding user with ID {}", id);
        UserDetail user = userService.findUser(id);
        model.addAttribute("user", user);
        return "/admin/user/view";
    }
}
