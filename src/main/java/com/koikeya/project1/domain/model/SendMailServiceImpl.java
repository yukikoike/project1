package com.koikeya.project1.domain.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.koikeya.project1.domain.service.SendMailService;

@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private MailSender mailSender;

    public void send(MailForm mailForm) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(mailForm.getMail());
        msg.setTo("yuki.koike8527@gmail.com"); // 管理者アドレス
        msg.setSubject("お問い合わせがありました");
        msg.setText(makeContent(mailForm));
        mailSender.send(msg);
        }

    public String makeContent(MailForm mailForm){
            return "名前: " + mailForm.getName() + "\n" +
            "性別: " + mailForm.getSex() + "\n" +
            "問い合わせ内容: " + mailForm.getContent();
    }
}
