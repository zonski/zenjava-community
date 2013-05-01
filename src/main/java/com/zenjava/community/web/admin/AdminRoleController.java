package com.zenjava.community.web.admin;

import com.zenjava.community.service.UserService;
import com.zenjava.community.service.data.RoleDetail;
import com.zenjava.community.service.data.RoleRef;
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
public class AdminRoleController {

    private static final Logger log = LoggerFactory.getLogger(AdminRoleController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/role/list")
    public String showRoleListPage(Model model) {
        log.debug("Finding all roles");
        List<RoleRef> roles = userService.findAllRoles();
        model.addAttribute("roles", roles);
        return "/admin/role/list";
    }

    @RequestMapping(value = "/role/{id}")
    public String showRoleListPage(Model model, @PathVariable("id") long id) {
        log.debug("Finding role with ID {}", id);
        RoleDetail role = userService.findRole(id);
        model.addAttribute("role", role);
        return "/admin/role/view";
    }
}
