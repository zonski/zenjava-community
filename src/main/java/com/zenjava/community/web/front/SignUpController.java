package com.zenjava.community.web.front;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.zenjava.community.service.UserService;
import com.zenjava.community.service.data.SignUpRequest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.awt.image.BufferedImage;

@Controller
public class SignUpController {

    private static final Logger log = LoggerFactory.getLogger(SignUpController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private Producer captchaProducer;

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

    @ResponseBody
    @RequestMapping("/checkusername.ajax")
    public Boolean isUsernameAvailable(@RequestParam String username) {
        return userService.isUsernameAvailable(username);
    }

    @RequestMapping("/captcha")
    public ModelAndView generateCaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        // create the text and matching image
        String capText = captchaProducer.createText();
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        BufferedImage bi = captchaProducer.createImage(capText);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }

    @RequestMapping(value = "/signup.do")
    public String signUp(HttpServletRequest httpRequest, @ModelAttribute("signUp") @Valid SignUpRequest request, BindingResult result) {
        log.info("Signing up new user");

        // check capture code
        String captchaId = (String) httpRequest.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        String response = request.getCaptchaResponse();
        log.debug("Validating captcha response: '" + response + "'");
        if (!StringUtils.equalsIgnoreCase(captchaId, response)) {
            result.rejectValue("captchaResponse", "error.invalidcaptcha", "Invalid Entry");
        }

        if (result.hasErrors()) {
            return "/signup/form";
        }

        userService.signUpUser(request);

        return "redirect:/signup/done";
    }

    @RequestMapping(value = "/activate/{code}")
    public String activateUserAccount(@PathVariable("code") String code) {
        log.debug("Showing sign up done page");
        userService.activateUserAccount(code);
        return "/signup/activated";
    }
}
