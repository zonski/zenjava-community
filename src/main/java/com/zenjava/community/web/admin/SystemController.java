package com.zenjava.community.web.admin;

import com.zenjava.community.service.SystemService;
import com.zenjava.community.service.data.SystemInfoDetail;
import com.zenjava.community.service.data.SystemSetupRequest;
import com.zenjava.community.service.data.exception.SystemNotSetupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SystemController {

    private static final Logger log = LoggerFactory.getLogger(SystemController.class);

    @Autowired
    private SystemService systemService;

    @RequestMapping(value = "/admin/setup")
    public String showSetupSystemPage(Model model) {
        try {
            log.debug("Showing system information");
            SystemInfoDetail systemInfo = systemService.getSystemInfo();
            model.addAttribute("systemInfo", systemInfo);
            return "/admin/setup/view";
        } catch (SystemNotSetupException e) {
            log.debug("System is not yet setup, showing system setup page");
            model.addAttribute("command", new SystemSetupRequest("Dev System", "This is a development system",
                    "http://localhost:8080/", "smtp.gmail.com", "587", "someone@gmail.com"));
            return "/admin/setup/form";
        }
    }

    @RequestMapping(value = "/admin/setup.do")
    public String setupSystem(@ModelAttribute("setup") SystemSetupRequest request, BindingResult result) {
        log.info("Setting up system");
        systemService.setupSystem(request);
        return "redirect:/admin/setup";
    }
}
