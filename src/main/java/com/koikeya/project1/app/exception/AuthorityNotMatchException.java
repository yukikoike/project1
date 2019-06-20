package com.koikeya.project1.app.exception;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 権限不一致例外クラス
 */
public class AuthorityNotMatchException extends UsernameNotFoundException {

    /**
     * コンストラクタ
     *
     * @param msg msg
     */
    public AuthorityNotMatchException(String msg) {
        super(msg);
    }
}
