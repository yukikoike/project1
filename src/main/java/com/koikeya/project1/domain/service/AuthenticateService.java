package com.koikeya.project1.domain.service;

import com.koikeya.project1.app.exception.UserNotFoundException;

/**
 * 認証サービスインターフェース
 *
 * @author user
 *
 */
public interface AuthenticateService {

    /**
     * 認証して登録する
     */
    public void authenticateAndSignUp(String uUid) throws UserNotFoundException;
}
