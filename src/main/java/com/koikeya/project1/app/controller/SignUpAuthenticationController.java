package com.koikeya.project1.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koikeya.project1.app.form.UserForm;
import com.koikeya.project1.domain.model.TempUser;
import com.koikeya.project1.domain.service.SignUpAuthenticationService;

@Controller
public class SignUpAuthenticationController {

    /**
     * ロガー
     */
    Logger logger = LoggerFactory.getLogger(SignUpAuthenticationController.class);

    /**
     * 会員登録認証オブジェクト
     */
    @Autowired
    SignUpAuthenticationService signUpAuthenticationService;

    /**
     * 一時ユーザーオブジェクト
     */
    @Autowired
    TempUser tempUser;


    /**
     * メールアドレス認証画面へ遷移する
     *
     * @param userForm ユーザーフォームオブジェクト
     * @return メールアドレス認証画面のパス
     */
    @RequestMapping("sign_up_authentication")
    String signUpAuthentication(@ModelAttribute("userForm") UserForm userForm, HttpServletRequest request) {
        logger.info("signUpAuthentication entered");
        HttpSession session = request.getSession();
        tempUser.setRoleId(request.getParameter("roleId"));
        tempUser.setLastName(request.getParameter("lastName"));
        tempUser.setRuby1(request.getParameter("ruby1"));
        tempUser.setFirstName(request.getParameter("firstName"));
        tempUser.setRuby2(request.getParameter("ruby2"));
        tempUser.setDateOfBirth(request.getParameter("dateOfBirth"));
        tempUser.setEmailAddress(request.getParameter("emailAddress"));
        tempUser.setPassword(request.getParameter("password"));
        signUpAuthenticationService.signUpAuthentication(tempUser);

        return "complete-temp-registation";
    }
}
