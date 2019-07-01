package com.koikeya.project1.domain.service.impl;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;

import javax.mail.MessagingException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;

import com.koikeya.project1.domain.model.MailForm;
import com.koikeya.project1.domain.service.SendMailService;

/**
 * メール送信サービステストクラス
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Transactional
public class SendMailServiceImplTest {

    /**
     * メール送信サービス
     */
    @Autowired
    SendMailService SendMailService;

    /**
     * メールフォームクラス
     */
    @Autowired
    MailForm mailForm;

    private static Wiser wiser;


    /**
     * メールサーバーを立てる
     *
     * @throws Exception 例外
     */
    // @BeforeClass・・・ pubic void なメソッドに付与することで，各テストメソッドを実行する前に1度だけ実行してくれる．
    // いわゆる setup メソッド
    @BeforeClass
    public static void メールサーバを立てる() throws Exception {
        wiser = new Wiser();
        wiser.setPort(9999);
        wiser.setHostname("localhost");
//        wiser.setPort(587);
//        wiser.setHostname("smtp.gmail.com");
        wiser.start();

    }

    /**
     * メールサーバを落とす
     *
     * @throws Exception 例外
     */
    // pubic void なメソッドに付与することで，各テストメソッドを実行した前に1度だけ実行してくれる．
    // いわゆる teardown メソッド
    @AfterClass
    public static void メールサーバを落とす() throws Exception {
        wiser.stop();
    }

    /**
     * メールを送信できることをテストする
     *
     * @throws MessagingException MessagingException
     * @throws IOException 入出力例外
     */
    @Test
    public void メール通知() throws MessagingException, IOException {

        mailForm.setContent("aaaa");
        mailForm.setName("sssss");
        mailForm.setSex("男");
        mailForm.setMail("yuki.koike8527@gmail.com");
        SendMailService.send(mailForm);

        //検証
        List<WiserMessage> messages = wiser.getMessages();

        assertThat(messages.size(), is(1));
        // 送信元
        assertThat(messages.get(0).getEnvelopeSender(), is("yuki.koike8527@gmail.com"));
        // 送信先
        assertThat(messages.get(0).getEnvelopeReceiver(), is("yuki.koike8527@gmail.com"));
        assertThat(messages.get(0).getMimeMessage().getSubject(), is("お問い合わせがありました"));

        // 本文取得
        InputStream inputStream = messages.get(0).getMimeMessage().getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));

        assertThat(reader.readLine(), is("名前: sssss"));
        assertThat(reader.readLine(), is("性別: 男"));
        assertThat(reader.readLine(), is("問い合わせ内容: aaaa"));
    }

}
