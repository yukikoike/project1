package com.koikeya.project1.app.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koikeya.project1.app.form.UserForm;
import com.koikeya.project1.domain.model.User;
import com.koikeya.project1.domain.service.RegisteredCheck;

/**
 * 会員登録処理コントローラークラス
 *
 * @author user
 *
 */
@Controller
public class SignUpProcessController {

    /**
     * ロガー
     */
    Logger logger = LoggerFactory.getLogger(SignUpProcessController.class);

    /**
     * メールアドレス登録済みチェックオブジェクト
     */
    @Autowired
    RegisteredCheck registeredCheck;

    /**
     * ユーザーオブジェクト
     */
    @Autowired
    User user;


    /**
     * 登録済みチェックをする
     *
     * @param inputEmailAddress 入力したメールアドレス
     * @return 真偽
     */
    @RequestMapping("registered_check")
    boolean registeredCheck(@RequestParam("inputEmailAddress") String inputEmailAddress) {
        user.setEmailAddress(inputEmailAddress);
        return registeredCheck.registeredCheck(user);
    }

    /**
     * 会員登録確認画面へ遷移する
     *
     * @param userForm ユーザーフォームオブジェクト
     * @param result バリデーションの結果
     * @return 会員登録確認画面のパス
     */
    @RequestMapping("sign_up_process")
    String signUpProcess(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult result) {
        logger.info("Entered");
        if (result.hasErrors()) {
            return "sign_up";
        }
        return "sign_up_confirm";
    }
}
