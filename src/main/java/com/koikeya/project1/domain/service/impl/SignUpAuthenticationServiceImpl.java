package com.koikeya.project1.domain.service.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.koikeya.project1.app.form.UserForm;
import com.koikeya.project1.app.helper.SendMailHelper;
import com.koikeya.project1.app.properties.AppMyProperty;
import com.koikeya.project1.app.util.DateTimeUtils;
import com.koikeya.project1.domain.model.MailForm;
import com.koikeya.project1.domain.model.TempUser;
import com.koikeya.project1.domain.repository.TempUserRepository;
import com.koikeya.project1.domain.service.SignUpAuthenticationService;

@Service
public class SignUpAuthenticationServiceImpl implements SignUpAuthenticationService {

    /**
     * ロガー
     */
    Logger logger = LoggerFactory.getLogger(SignUpAuthenticationServiceImpl.class);

    /**
     * 一時ユーザーオブジェクト
     */
    @Autowired
    TempUser tempUser;

    /**
     * 一時ユーザーリポジトリ
     */
    @Autowired
    TempUserRepository tempUserRepository;

    /**
     * パスワードエンコーダー
     */
    @Qualifier("passwordEncoderImpl")
    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * AppMyProperty定数取得オブジェクト
     */
    @Autowired
    AppMyProperty appMyProperty;

    /**
     * メールフォームオブジェクト
     */
    MailForm mailForm;

    /**
     * メール送信ヘルパーオブジェクト
     */
    SendMailHelper sendMailHelper;


    /*
     * (非 Javadoc)
     * @see com.koikeya.project1.domain.service.SignUpAuthenticationService#signUpAuthentication(com.koikeya.project1.domain.model.TempUser)
     */
    @Override
    public void signUpAuthentication(UserForm userForm) {
        logger.info("signUpAuthentication" + "entered");
        if (!tempUserRepository.existsByEmailAddressAndCreatedAtGreaterThanEqual(
          tempUser.getEmailAddress(), DateTimeUtils.fetchTimeThirtyMinutesAgo())) {

            String uUid = UUID.randomUUID().toString();
            tempUser.setUuid(UUID.randomUUID().toString());
            tempUser.setEmailAddress(userForm.getEmailAddress());
            tempUser.setRoleId(userForm.getRoleId());
            tempUser.setLastName(userForm.getLastName());
            tempUser.setRuby1(userForm.getRuby1());
            tempUser.setFirstName(userForm.getFirstName());
            tempUser.setRuby2(userForm.getRuby2());
            tempUser.setDateOfBirth(userForm.getDateOfBirth());
            tempUser.setPassword(passwordEncoder.encode(userForm.getPassword()));
            tempUserRepository.saveAndFlush(tempUser);

            //メールを送信する
            mailForm.setContent("http://" + appMyProperty.getIpAddress() + ":"
              + appMyProperty.getPort() + "/authenticate" + "?id=" + uUid);

            sendMailHelper.send(mailForm);
        }
    }


}
