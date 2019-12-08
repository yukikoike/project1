package com.koikeya.project1.app.form;

import lombok.Data;

/**
 * ユーザーフォームクラス
 *
 * @author user
 *
 */
@Data
public class UserForm {

    /**
     * ID
     */
    private int id;

    /**
     * 権限ID
     */
    private String roleId;

    /**
     * 姓
     */
    private String lastName;

    /**
     * 名
     */
    private String firstName;

    /**
     * 生年月日
     */
    private String dateOfBirth;

    /**
     * パスワード
     */
    private String password;

    /**
     * メールアドレス
     */
    private String emailAddress;
}

