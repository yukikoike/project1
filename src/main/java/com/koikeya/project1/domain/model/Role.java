package com.koikeya.project1.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 役割エンティティクラス
 */
@Data
@Entity
@Table(name = "ROLE")
public class Role implements Serializable {

    /**
     * 権限ID
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 権限名
     */
    @Column(name = "ROLE_NAME")
    private String roleName;

    /**
     * 更新日時
     */
    @Column(name = "UPDATED_AT")
    private String updatedAt;

    /**
     * 登録日時
     */
    @Column(name = "CREATED_AT")
    private String createdAt;
}
