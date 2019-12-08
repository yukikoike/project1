package com.koikeya.project1.domain.service;

import com.koikeya.project1.domain.model.MailForm;

/**
 * メール送信サービス
 */
public interface SendMailService {

    /**
     * メールを送信する
     *
     * @param mailForm メールフォーム
     */
    public void send(MailForm mailForm);
}
