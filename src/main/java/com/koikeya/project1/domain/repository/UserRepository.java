package com.koikeya.project1.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koikeya.project1.domain.model.User;

/**
 * ユーザーリポジトリインタフェース
 */
public interface UserRepository extends JpaRepository<User, String> {
}
