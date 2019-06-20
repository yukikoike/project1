package com.koikeya.project1.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RadixConversionController {

    Logger logger = LoggerFactory.getLogger(RadixConversionController.class);

    @RequestMapping("radix_conversion")
    String radixConversion(HttpServletRequest request) {
        logger.info("RadixConversion entered");
        // int  str = request.getQueryString().indexOf("=");
        // String queryString = "/" + request.getQueryString().substring(str + 1);
        // logger.info(request.getContextPath() +  queryString);
        logger.info("page:" + request.getHeader("REFERER"));
        return "radix_conversion";
    }
}
