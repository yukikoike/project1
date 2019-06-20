package com.koikeya.project1.domain.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * ユーザーエンティティクラス
 */
 @Data
@Entity
@Table(name = "USER")
public class User implements Serializable {

    /**
     * ユーザーID
     */
    @Id
    @Column(name = "ID")
    private String id;

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
     * 名
     */
    @Column(name = "FIRST_NAME")
    private Date firstName;

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
}
