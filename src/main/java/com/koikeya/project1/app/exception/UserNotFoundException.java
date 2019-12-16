package com.koikeya.project1.app.exception;

/**
 * 会員不存在例外クラス
 *
 * @author user
 *
 */
public class UserNotFoundException extends Project1CommonException {

    /**
     * コンストラクタ
     *
     * @param msg メッセージ
     */
    public UserNotFoundException(String msg) {
        super(msg);
    }

    /**
     * コンストラクタ
     *
     * @param cause 原因
     */
    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
