package com.koikeya.project1.domain.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.koikeya.project1.app.exception.AuthorityNotMatchException;
import com.koikeya.project1.domain.model.Role;
import com.koikeya.project1.domain.model.User;
import com.koikeya.project1.domain.repository.RoleRepository;
import com.koikeya.project1.domain.repository.UserRepository;

/**
 * UserDetailsService実装クラス
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * ユーザーリポジトリ
     */
    @Autowired
    UserRepository userRepository;

    /**
     * 役割リポジトリ
     */
    @Autowired
    RoleRepository roleRepository;


    /*
     * (非 Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        Optional<User> userOp = userRepository.findById(userId);
        User user = userOp.orElseThrow(() -> new UsernameNotFoundException("user not found."));

        return new UserDetailsImpl(user, getAuthority(user.getRoleId()));
    }

    /**
     * ユーザー情報の権限IDに一致する権限を権限マスタから取得する
     *
     * @param roleId 役割ID
     * @return ログインするユーザーの権限リスト
     */
    private Collection<GrantedAuthority> getAuthority(String roleId)
            throws AuthenticationCredentialsNotFoundException {

        Optional<Role> roleOp = roleRepository.findById(roleId);
        Role role = roleOp.orElseThrow(() -> new AuthenticationCredentialsNotFoundException("user is not found."));

        return createAuthorityList(role.getRoleName());
    }

    /**
     * 権限マスタから取得した権限に相応しいspring-security上の権限を付与する
     *
     * @param roleName 権限名
     * @return ユーザーに相応しい権限リスト
     * @throws AuthorityNotMatchException 権限不一致例外
     */
    private Collection<GrantedAuthority> createAuthorityList(String roleName)
            throws AuthorityNotMatchException {

        // breakしないのはわざとです
        switch (roleName) {
            case ("ADMIN"):
                return AuthorityUtils.createAuthorityList("ROLE_MEMBER", "PAID_MEMBER", "ROLE_ADMIN");
            case ("PAID_MEMBER"):
                return AuthorityUtils.createAuthorityList("ROLE_MEMBER", "PAID_MEMBER");
            case ("MEMBER"):
                return AuthorityUtils.createAuthorityList("ROLE_MEMBER");
            default:
                throw new AuthorityNotMatchException("authority is not match.");
        }
    }
}
