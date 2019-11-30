package com.koikeya.project1.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 会員登録画面遷移コントローラークラス
 *
 * @author user
 *
 */
@Controller
public class SignUpController {

    Logger logger = LoggerFactory.getLogger(SignUpController.class);

    @RequestMapping("sign_up")
    String signUp() {
        logger.info("Entered");

        return "sign_up";
    }
}
