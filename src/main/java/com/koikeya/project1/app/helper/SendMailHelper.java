package com.koikeya.project1.app.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.koikeya.project1.domain.model.MailForm;

/**
 * メール送信ヘルパークラス
 *
 * @author user
 *
 */
@Component
public class SendMailHelper {

    /**
     * MailSender
     */
    @Autowired
    private MailSender mailSender;


    /**
     * コンストラクタ
     */
    protected SendMailHelper() {
        super();
    }

    /**
     * メールを送信する
     *
     * @param mailForm メールフォームオブジェクト
     */
    public void send(MailForm mailForm) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("yuki.koike8527@gmail.com"); // 管理者アドレス
        msg.setTo(mailForm.getMail());
        msg.setSubject("project1 アカウント確認のお願い");
        msg.setText(makeContent(mailForm));
        mailSender.send(msg);
    }

    /**
     * コンテンツを編集する
     *
     * @param mailForm メールフォーム
     * @return メールフォームの内容
     */
    private String makeContent(MailForm mailForm){
            return mailForm.getName() + "さん\n\n" +
              "以下のリンクにアクセスしてアカウントを認証してください" + "\n"
              + mailForm.getContent();
    }
}
