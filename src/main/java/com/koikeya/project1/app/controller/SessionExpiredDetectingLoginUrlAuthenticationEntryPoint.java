package com.koikeya.project1.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

//@Component
public class SessionExpiredDetectingLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    Logger logger = LoggerFactory.getLogger(SessionExpiredDetectingLoginUrlAuthenticationEntryPoint.class);


    public SessionExpiredDetectingLoginUrlAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
        // TODO 自動生成されたコンストラクター・スタブ
    }

    @Override
    protected String buildRedirectUrlToLoginPage(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {

        String redirectUrl = super.buildRedirectUrlToLoginPage(request, response, authException);
        logger.info("redirectUrl:" + "redirectUrl");
        if (isRequestedSessionInvalid(request)) {
            redirectUrl += redirectUrl.contains("?") ? "&" : "?";
            redirectUrl += "timeout";
        }
        return redirectUrl;
    }

    private boolean isRequestedSessionInvalid(HttpServletRequest request) {
        return request.getRequestedSessionId() != null && !request.isRequestedSessionIdValid();
    }
}
