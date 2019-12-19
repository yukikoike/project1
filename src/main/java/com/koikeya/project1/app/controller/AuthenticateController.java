package com.koikeya.project1.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koikeya.project1.app.exception.UserNotFoundException;
import com.koikeya.project1.domain.service.AuthenticateService;

/**
 * 認証コントローラークラス
 *
 * @author user
 *
 */
@CrossOrigin
@Controller
public class AuthenticateController {

    /**
     * ロガー
     */
    Logger logger = LoggerFactory.getLogger(AuthenticateController.class);

    /**
     * 認証サービスオブジェクト
     */
    @Autowired
    AuthenticateService authenticateService;


    /**
     * 認証済み画面へ遷移する
     *
     * @return 認証済み画面のパス
     * @throws UserNotFoundException
     */
    @CrossOrigin
    @RequestMapping("authenticate")
    String authenticate(@RequestParam("id") String id) throws UserNotFoundException {
        logger.info("authenticate entered");
        authenticateService.authenticateAndSignUp(id);
        return "authenticate";
    }

}
