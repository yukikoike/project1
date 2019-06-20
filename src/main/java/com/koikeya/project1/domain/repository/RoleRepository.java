package com.koikeya.project1.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koikeya.project1.domain.model.Role;

/**
 * 役割リポジトリインタフェース
 */
public interface RoleRepository extends JpaRepository<Role, String> {
}
