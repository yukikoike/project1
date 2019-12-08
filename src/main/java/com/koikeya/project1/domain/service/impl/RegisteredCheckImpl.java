package com.koikeya.project1.domain.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koikeya.project1.domain.model.User;
import com.koikeya.project1.domain.repository.UserRepository;
import com.koikeya.project1.domain.service.RegisteredCheck;

@Service
public class RegisteredCheckImpl implements RegisteredCheck {

    /**
     * ロガー
     */
    Logger logger = LoggerFactory.getLogger(RegisteredCheckImpl.class);

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


    /*
     * (非 Javadoc)
     * @see com.koikeya.project1.domain.service.RegisteredCheck#registeredCheck(com.koikeya.project1.domain.model.User)
     */
    @Override
    public boolean registeredCheck(User user) {
        logger.info("Entered");
        return userRepository.existsByEmailAddress(user.getEmailAddress());
    }
}
