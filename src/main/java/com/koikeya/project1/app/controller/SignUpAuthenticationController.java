package com.koikeya.project1.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koikeya.project1.app.form.UserForm;

@Controller
public class SignUpAuthenticationController {

    /**
     * ロガー
     */
    Logger logger = LoggerFactory.getLogger(SignUpAuthenticationController.class);


    /**
     * メールアドレス認証画面へ遷移する
     *
     * @param userForm ユーザーフォームオブジェクト
     * @return メールアドレス認証画面のパス
     */
    @RequestMapping("sign_up_authentication")
    String signUpAuthentication(@ModelAttribute("userForm") UserForm userForm) {
        logger.info("signUpAuthentication entered");

        return null;

    }

}
