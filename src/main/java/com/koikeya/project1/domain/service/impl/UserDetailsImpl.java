package com.koikeya.project1.domain.service.impl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.koikeya.project1.domain.model.User;

import lombok.Data;

/**
 * UserDetails実装クラス
 */
@Data
public class UserDetailsImpl implements UserDetails {

    /**
     * ユーザー
     */
    private final User user;

    /**
     * 権限リスト
     */
    private Collection<GrantedAuthority> authorities;


    /**
     * コンストラクタ
     *
     * @param user ユーザー
     * @param authorities 権限リスト
     */
    public UserDetailsImpl(User user, Collection<GrantedAuthority> authorities) {
        super();
        this.user = user;
        this.authorities = authorities;
    }

    /*
     * (非 Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /*
     * (非 Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
     */
    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    /*
     * (非 Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
     */
    @Override
    public String getUsername() {
        return Integer.toString(this.user.getId());
    }

    // アカウント期限切れ、アカウントロック、パスワード有効期限切れ、アカウント無効化に関するプロパティは使用しない
    /*
     * (非 Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // アカウント期限切れ、アカウントロック、パスワード有効期限切れ、アカウント無効化に関するプロパティは使用しない
    /*
     * (非 Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
     */
    @Override
    public boolean isAccountNonLocked() {
        // TODO 自動生成されたメソッド・スタブ
        return true;
    }

    // アカウント期限切れ、アカウントロック、パスワード有効期限切れ、アカウント無効化に関するプロパティは使用しない
    /*
     * (非 Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
     */
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO 自動生成されたメソッド・スタブ
        return true;
    }

    // アカウント期限切れ、アカウントロック、パスワード有効期限切れ、アカウント無効化に関するプロパティは使用しない
    /*
     * (非 Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
     */
    @Override
    public boolean isEnabled() {
        // TODO 自動生成されたメソッド・スタブ
        return true;
    }
}
