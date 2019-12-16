package com.koikeya.project1.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koikeya.project1.domain.model.TempUser;

/**
 * 一時ユーザーリポジトリインターフェース
 *
 * @author user
 *
 */
public interface TempUserRepository extends JpaRepository<TempUser, String> {

    /**
     * ユーザー情報が存在するか判定する
     *
     * @param emailAddress メールアドレス
     * @return 真偽
     */
    public boolean existsByEmailAddressAndCreatedAtGreaterThanEqual(String emailAddress, String time);
}
