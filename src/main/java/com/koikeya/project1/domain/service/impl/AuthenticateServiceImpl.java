package com.koikeya.project1.domain.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koikeya.project1.app.exception.UserNotFoundException;
import com.koikeya.project1.domain.model.TempUser;
import com.koikeya.project1.domain.model.User;
import com.koikeya.project1.domain.repository.TempUserRepository;
import com.koikeya.project1.domain.repository.UserRepository;
import com.koikeya.project1.domain.service.AuthenticateService;

/**
 * 認証サービス実装クラス
 *
 * @author user
 *
 */
@Service
public class AuthenticateServiceImpl implements AuthenticateService {

    /**
     * ロガー
     */
    Logger logger = LoggerFactory.getLogger(AuthenticateServiceImpl.class);

    /**
     * ユーザーリポジトリ
     */
    @Autowired
    UserRepository userRepository;

    /**
     * 一時ユーザーリポジトリ
     */
    @Autowired
    TempUserRepository tempUserRepository;

    /**
     * ユーザーオブジェクト
     */
    @Autowired
    User user;


    /*
     * (非 Javadoc)
     * @see com.koikeya.project1.domain.service.AuthenticateService#authenticateAndSignUp()
     */
    @Override
    public void authenticateAndSignUp(String uUid) throws UserNotFoundException {
        TempUser tempUser = tempUserRepository.findById(uUid).orElseThrow(
          () -> new UserNotFoundException("user is not found or disable."));

        logger.info("authenticateAndSignUp entered");
        user.setEmailAddress(tempUser.getEmailAddress());
        user.setRoleId(tempUser.getRoleId());
        user.setLastName(tempUser.getLastName());
        user.setRuby1(tempUser.getRuby1());
        user.setFirstName(tempUser.getFirstName());
        user.setRuby2(tempUser.getRuby2());
        user.setDateOfBirth(tempUser.getDateOfBirth());
        user.setPassword(tempUser.getPassword());
        userRepository.saveAndFlush(user);

        tempUserRepository.deleteById(String.valueOf(user.getId()));
    }
}
