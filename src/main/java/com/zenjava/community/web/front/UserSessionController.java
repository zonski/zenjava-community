package com.zenjava.community.web.front;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserSessionController {

    private static final Logger log = LoggerFactory.getLogger(UserSessionController.class);

    @RequestMapping(value = "/login")
    public String showLoginPage() {
        log.debug("Showing login page");
        return "/login";
    }

    @RequestMapping(value = "/denied")
    public String showAccessDeniedPage() {
        log.debug("Showing access denied page");
        return "/denied";
    }
}
