package com.koikeya.project1.app.controller;

import java.time.LocalDateTime;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * HttpSessionListener継承クラス
 */
@WebListener
public class HttpSessionListenerImpl implements HttpSessionListener {

    @Override public  void sessionCreated(HttpSessionEvent se) {
        System.out.print(LocalDateTime.now());
        System.out.print(" Session created ");
        System.out.println(se.getSession().getId());
      }
      @Override public void sessionDestroyed(HttpSessionEvent se) {
        System.out.print(LocalDateTime.now());
        System.out.print(" Session destroyed ");
        System.out.println(se.getSession().getId());
      }
}
