package com.koikeya.project1.domain.model;

import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * メールフォームクラス
 */
@Data
@Component
public class MailForm{

     /**
      * メールアドレス
      */
      private String mail;

      /**
       * 名前
       */
      private String name;

      /**
       * 性別
       */
      private String sex;

      /**
       * 内容
       */
      private String content;
}
