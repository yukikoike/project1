package com.koikeya.project1.domain.model;

/**
 * 役割名定数クラス
 */
public enum RoleName {

    /**
     * 無料会員
     */
    USER(1, "無料会員"),

    /**
     * 有料会員
     */
    PAYING_MEMBER(2, "有料会員"),

    /**
     * 管理者
     */
    ADMIN(3, "管理者");


    /**
     * 権限ID
     */
    private final int roleId;

    /**
     * 権限名
     */
    private final String roleName;


    /**
     * コンストラクタ
     *
     * @param roleId 権限ID
     * @param roleName 権限名
     */
    RoleName(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    /*
     * (非 Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return this.roleName;
    }

    /**
     * 権限名を取得する
     *
     * @return 権限名
     */
    public int getroleId() {
        return roleId;
    }
}
