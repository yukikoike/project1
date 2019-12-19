package com.koikeya.project1.domain.service;

import com.koikeya.project1.domain.model.TempUser;

/**
 * 会員登録認証インターフェース
 *
 * @author user
 *
 */
public interface SignUpAuthenticationService {

    /**
     * 会員登録認証をする
     *
     * @param tempUser ユーザーオブジェクト
     */
    public void signUpAuthentication(TempUser tempUser);
}
