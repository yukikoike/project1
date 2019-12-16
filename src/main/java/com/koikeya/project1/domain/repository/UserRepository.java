package com.koikeya.project1.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koikeya.project1.domain.model.User;

/**
 * ユーザーリポジトリインターフェース
 */
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * ユーザー情報を取得する
     *
     * @param emailAddress メールアドレス
     * @return ユーザー情報
     */
    public User findByEmailAddress(String emailAddress);

    /**
     * ユーザー情報が存在するか判定する
     *
     * @param emailAddress メールアドレス
     * @return 真偽
     */
    public boolean existsByEmailAddress(String emailAddress);
}
