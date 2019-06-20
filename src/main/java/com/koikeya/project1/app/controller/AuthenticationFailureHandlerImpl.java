package com.koikeya.project1.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

/**
 * Spring Securityの認証失敗時に呼ばれるハンドラクラス
 */
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler{

    /* (非 Javadoc)
     * @see org.springframework.security.web.authentication.AuthenticationFailureHandler
     * #onAuthenticationFailure(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, org.springframework.security.core.AuthenticationException)
     */
    @Override
    public void onAuthenticationFailure(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            AuthenticationException authenticationException)
                    throws IOException, ServletException {

        String errorId = "";
        // ExceptionからエラーIDをセットする
        if(authenticationException instanceof BadCredentialsException){
            errorId = "MSG_ERROR_0001";
        }

        String str = httpServletRequest.getHeader("REFERER");
        // ログイン画面にリダイレクトする
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/"
          + str.substring(str.lastIndexOf("login")));
//          + "/login_index?error=" + errorId);
    }
}