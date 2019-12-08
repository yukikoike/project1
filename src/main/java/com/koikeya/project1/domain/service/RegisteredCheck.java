package com.koikeya.project1.domain.service;

import com.koikeya.project1.domain.model.User;

/**
 * メールアドレス登録済みチェックインターフェース
 *
 * @author user
 *
 */
public interface RegisteredCheck {

    /**
     * メールアドレスが登録済みかチェックする
     *
     * @param ユーザーオブジェクト
     * @return 真偽
     */
    public boolean registeredCheck(User user);
}
