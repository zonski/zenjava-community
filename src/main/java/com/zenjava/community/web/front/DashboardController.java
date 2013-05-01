package com.zenjava.community.web.front;

import com.zenjava.community.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

    private static final Logger log = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/dashboard")
    public String showDashboard() {
        log.debug("Showing dashboard");
        userService.findUser("danz");
        return "/dashboard";
    }
}
