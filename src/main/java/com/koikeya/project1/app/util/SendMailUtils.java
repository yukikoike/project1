package com.koikeya.project1.app.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.koikeya.project1.domain.model.MailForm;

/**
 * メール送信ユーティリティクラス
 *
 * @author user
 *
 */
@Component
public class SendMailUtils {

    /**
     * 静的MailSender
     */
    static MailSender staticMailSender;

    /**
     * 静的SimpleMailMessage
     */
    static SimpleMailMessage staticMsg;

    /**
     * MailSender
     */
    @Autowired(required = true)
    private MailSender mailSender;

    /**
     * SimpleMailMessage
     */
    @Autowired
    private SimpleMailMessage msg;


    /**
     * 静的MailSenderを初期化する
     */
    @PostConstruct
    private void initialize() {
        SendMailUtils.staticMailSender = mailSender;
        SendMailUtils.staticMsg = msg;
    }

    /**
     * コンストラクタ
     */
    protected SendMailUtils() {
        super();
    }

    /**
     * メールを送信する
     *
     * @param mailForm メールフォームオブジェクト
     */
    public static void send(MailForm mailForm) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("yuki.koike8527@gmail.com");
        msg.setTo(mailForm.getMail()); // 管理者アドレス
        msg.setSubject("project1 アカウント確認のお願い");
        msg.setText(makeContent(mailForm));
        staticMailSender.send(msg);
    }

    /**
     * コンテンツを編集する
     *
     * @param mailForm メールフォーム
     * @return メールフォームの内容
     */
    private static String makeContent(MailForm mailForm){
            return mailForm.getName() + "さん\n\n" +
              "以下のリンクにアクセスしてアカウントを認証してください" + "\n" +
              "問い合わせ内容: " + mailForm.getContent();
    }
}
