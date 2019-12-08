package com.koikeya.project1.app.controller;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koikeya.project1.app.form.UserForm;

/**
 * 会員登録画面遷移コントローラークラス
 *
 * @author user
 *
 */
@Controller
public class SignUpController {

    /**
     * ロガー
     */
    Logger logger = LoggerFactory.getLogger(SignUpController.class);

    /**
     * 権限
     */
 // これがスタティックイニシャライザ?
    final static Map<Integer, String> SELECT_ROLE =
      Collections.unmodifiableMap(new LinkedHashMap<Integer, String>() {{
        put(1, "会員");
        put(2, "有料会員");
        put(3, "管理者");
      }
    });

    /**
     * 会員登録画面へ遷移する
     *
     * @param userForm ユーザーフォームオブジェクト
     * @return 会員登録画面のパス
     */
    @RequestMapping("sign_up")
    String signUp(@ModelAttribute("userForm") UserForm userForm, Model model) {
        logger.info("Entered");
        model.addAttribute("selectRole", SELECT_ROLE);

        return "sign_up";
    }
}
