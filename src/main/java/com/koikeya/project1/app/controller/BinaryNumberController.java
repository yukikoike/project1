package com.koikeya.project1.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 二進数コントローラークラス
 *
 * @author user
 *
 */
@Controller
public class BinaryNumberController {

    /**
     * ロガー
     */
    Logger logger = LoggerFactory.getLogger(BinaryNumberController.class);


    /**
     * 二進数問題画面へ遷移する
     *
     * @param request リクエスト
     * @return 二進数問題画面のパス
     */
    @RequestMapping("binary_number")
    String radixConversion(HttpServletRequest request) {
        logger.info("BinaryNumbe entered");
        // int  str = request.getQueryString().indexOf("=");
        // String queryString = "/" + request.getQueryString().substring(str + 1);
        // logger.info(request.getContextPath() +  queryString);
        logger.info("page:" + request.getHeader("REFERER"));
        return "binary_number";
    }
}
