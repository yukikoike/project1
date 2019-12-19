package com.koikeya.project1.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 一時ユーザーエンティティクラス
 *
 * @author user
 *
 */
@Data
@Entity
@Table(name = "TEMP_USER")
@Component
public class TempUser implements Serializable {

        /**
         * UUID
         */
        @Id
        @Column(name = "UUID")
        private String uuid;

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
         * 登録日時
         */
        @Column(name = "CREATED_AT", insertable = false, updatable = false)
        private String createdAt;
}
