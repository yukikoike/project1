package com.koikeya.project1.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginBinaryNumberController {

    Logger logger = LoggerFactory.getLogger(LoginBinaryNumberController.class);

    @RequestMapping("login_binary_number")
    String loginForm(HttpServletRequest request, Model model) {
        logger.info("Entered");
        logger.info("page:" + request.getHeader("REFERER"));
        model.addAttribute("page", request.getHeader("REFERER"));
        return "login_binary_number";
    }
}
