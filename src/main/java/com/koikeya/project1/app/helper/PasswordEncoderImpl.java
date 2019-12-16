package com.koikeya.project1.app.helper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("passwordEncoderImpl")
public class PasswordEncoderImpl implements PasswordEncoder {

    /**
     * パスワードエンコーダーオブジェクト
     */
    private PasswordEncoder passwordEncoder;


    /**
     * コンストラクタ
     */
    public PasswordEncoderImpl() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    /*
     * (非 Javadoc)
     * @see org.springframework.security.crypto.password.PasswordEncoder#encode(java.lang.CharSequence)
     */
    @Override
    public String encode(CharSequence rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    /*
     * (非 Javadoc)
     * @see org.springframework.security.crypto.password.PasswordEncoder#matches(java.lang.CharSequence, java.lang.String)
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
