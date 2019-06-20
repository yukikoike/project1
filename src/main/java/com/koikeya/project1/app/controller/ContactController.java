package com.koikeya.project1.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.koikeya.project1.domain.model.MailForm;
import com.koikeya.project1.domain.service.SendMailService;

@Controller
public class ContactController {

    Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private SendMailService sendMailService;

    @GetMapping("contact")
    public String contact(Model model){
        logger.info("Contact Entered");
        return "contact";
  }
    @PostMapping("confirm")
    public String confirm(@ModelAttribute MailForm mailForm, Model model){
        model.addAttribute("mailForm", mailForm);
        logger.info("Confirm Entered");
        return "confirm";
  }

    @PostMapping("complete")
    public String complete(@ModelAttribute MailForm mailForm){
        sendMailService.send(mailForm);
        logger.info("Complete Entered");
        return "complete";
  }
}
