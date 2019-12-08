package com.koikeya.project1.domain.service.impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koikeya.project1.app.form.UserForm;
import com.koikeya.project1.app.helper.EncoderHelper;
import com.koikeya.project1.domain.model.User;
import com.koikeya.project1.domain.repository.UserRepository;
import com.koikeya.project1.domain.service.SignUpProcessService;

/**
 * 会員登録処理実装サービスクラス
 *
 * @author user
 *
 */
@Transactional
@Service
public class SignUpProcessServiceImpl implements SignUpProcessService {

    /**
     * ユーザーオブジェクト
     */
    @Autowired
    User user;

    /**
     * ユーザーリポジトリ
     */
    @Autowired
    UserRepository userRepository;

    /**
     * エンコーダーヘルパー
     */
    @Autowired
    EncoderHelper encoderHelper;

    /*
     * (非 Javadoc)
     * @see com.koikeya.project1.domain.service.SignUpProcessService#signUp(com.koikeya.project1.app.UserForm)
     */
    @Override
    public void signUp(UserForm userForm) {
        user.setRoleId(userForm.getRoleId());
        user.setLastName(userForm.getLastName());
        user.setFirstName(userForm.getFirstName());
        user.setDateOfBirth(Date.valueOf(userForm.getDateOfBirth()));
        user.setPassword(encoderHelper.encode(userForm.getPassword()));
        user.setEmailAddress(userForm.getEmailAddress());
        userRepository.saveAndFlush(user);
    }
}
