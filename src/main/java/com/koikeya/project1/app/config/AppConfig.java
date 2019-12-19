package com.koikeya.project1.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.koikeya.project1.app.controller.SessionExpiredDetectingLoginUrlAuthenticationEntryPoint;

/**
 * Bean設定クラス
 *
 * @author user
 *
 */
@Configuration
public class AppConfig {

    /**
     * パスワード符号化用オブジェクトを返す
     *
     * @return BCryptPasswordEncoderオブジェクト
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * ???
     *
     * @return ???
     */
    @Bean
    AuthenticationEntryPoint authenticationEntryPoint() {
        return new SessionExpiredDetectingLoginUrlAuthenticationEntryPoint("/login");
    }
}
