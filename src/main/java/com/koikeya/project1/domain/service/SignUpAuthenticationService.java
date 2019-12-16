package com.koikeya.project1.domain.service;

import com.koikeya.project1.app.form.UserForm;

public interface SignUpAuthenticationService {

    /**
     * 会員登録認証をする
     *
     * @param tempUser ユーザーオブジェクト
     */
    public void signUpAuthentication(UserForm userForm);
}
