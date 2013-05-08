package com.zenjava.community.web.front;

import com.zenjava.community.service.UserService;
import com.zenjava.community.service.data.SignUpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class SignUpController {

    private static final Logger log = LoggerFactory.getLogger(SignUpController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signup")
    public String showSignUpPage(Model model) {
        log.debug("Showing user sign up page");
        model.addAttribute("signUp", new SignUpRequest());
        return "/signup/form";
    }

    @RequestMapping(value = "/signup/done")
    public String showSignUpDonePage() {
        log.debug("Showing sign up done page");
        return "/signup/done";
    }

    @RequestMapping(value = "/signup.do")
    public String setupSystem(@ModelAttribute("signUp") @Valid SignUpRequest request, BindingResult result) {
        log.info("Signing up new user");

        if (result.hasErrors()) {
            return "/signup/form";
        }

        userService.signUpUser(request);

        return "redirect:/signup/done";
    }
}
