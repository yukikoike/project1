package com.koikeya.project1.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.koikeya.project1.domain.repository.UserRepository;

/**
 * 会員登録確認コントローラークラス
 *
 * @author user
 *
 */
@Controller
public class UserConfirmController {

    /**
     * ロガー
     */
    Logger logger = LoggerFactory.getLogger(UserConfirmController.class);

    /**
     * ユーザーリポジトリ
     */
    @Autowired
    UserRepository userRepository;

    /**
     * 会員登録の確認をする
     *
     * @return UUID?
     */
//    @RequestMapping("sign_up_confirm")
//    String signUpConfirm(@ModelAttribute("userForm") UserForm userForm) {
//        userRepository.existsByEmailAddress(emailAddress)
//    }
}
