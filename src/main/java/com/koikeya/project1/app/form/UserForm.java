package com.koikeya.project1.app.form;

import javax.validation.constraints.NotNull;

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
    @NotNull
    private String roleId;

    /**
     * 姓
     */
    @NotNull
    private String lastName;

    /**
     * セイ
     */
    @NotNull
    private String ruby1;

    /**
     * 名
     */
    @NotNull
    private String firstName;

    /**
     * メイ
     */
    @NotNull
    private String ruby2;

    /**
     * 生年月日
     */
    @NotNull
    private String dateOfBirth;

    /**
     * パスワード
     */
    @NotNull
    private String password;

    /**
     * メールアドレス
     */
    @NotNull
    private String emailAddress;
}
