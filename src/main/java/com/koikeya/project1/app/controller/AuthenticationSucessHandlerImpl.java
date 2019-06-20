package com.koikeya.project1.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * AuthenticationSuccessHandler実装クラス
 */
@Component
public class AuthenticationSucessHandlerImpl implements AuthenticationSuccessHandler {

    Logger logger = LoggerFactory.getLogger(AuthenticationSucessHandlerImpl.class);
    /*
     * (非 Javadoc)
     * @see org.springframework.security.web.authentication.AuthenticationSuccessHandler#onAuthenticationSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

//        int  str = request.getQueryString().indexOf("=");
//        String queryString = "/" + request.getQueryString().substring(str + 1);
         RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

         if (request.getRequestURI().contains("contact")) {
             redirectStrategy.sendRedirect(request, response, "/contact?");
         } else  if (request.getRequestURI().contains("radix_conversion")) {
             redirectStrategy.sendRedirect(request, response, "/radix_conversion?");
         } else {
             redirectStrategy.sendRedirect(request, response, "/");
         }
//        logger.info(queryString);
        // response.sendRedirect(queryString);
//        response.sendRedirect("/radix_conversion.html");
        // redirectStrategy.sendRedirect(request, response, queryString);

    }
}
