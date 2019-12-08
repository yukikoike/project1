package com.koikeya.project1.domain.service;

import com.koikeya.project1.app.form.UserForm;

/**
 * 会員登録処理サービスクラス
 *
 * @author user
 *
 */
public interface SignUpProcessService {

    /**
     * 会員登録をする
     */
    public void signUp(UserForm userForm);
}
