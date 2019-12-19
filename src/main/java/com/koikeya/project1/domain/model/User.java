package com.koikeya.project1.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * ユーザーエンティティクラス
 *
 * @author user
 *
 */
 @Data
@Entity
@Table(name = "USER")
@Component
public class User implements Serializable {

    /**
     * ユーザーID
     */
    // エンティティの主キーを表す
    @Id
    // カラム名を指定する
    @Column(name = "ID")
    // 主キー列にユニークな値を自動で生成する
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * メールアドレス
     */
    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    /**
     * 権限ID
     */
    @Column(name = "ROLE_ID")
    private String roleId;

    /**
     * 姓
     */
    @Column(name = "LAST_NAME")
    private String lastName;

    /**
     * セイ
     */
    @Column(name = "RUBY1")
    private String ruby1;

    /**
     * 名
     */
    @Column(name = "FIRST_NAME")
    private String firstName;

    /**
     * メイ
     */
    @Column(name = "RUBY2")
    private String ruby2;

    /**
     * 生年月日
     */
    @Column(name = "DATE_OF_BIRTH")
    private String dateOfBirth;

    /**
     *パスワード
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * 更新日時
     */
    @Column(name = "UPDATED_AT", insertable = false, updatable = false)
    private String updatedAt;

    /**
     * 登録日時
     */
    @Column(name = "CREATED_AT", insertable = false)
    private String createdAt;

    /**
     * 版
     */
    @Version
    @Column(name = "VERSION", insertable = false)
    private int version;
}
