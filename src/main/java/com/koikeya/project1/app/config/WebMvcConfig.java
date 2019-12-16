package com.koikeya.project1.app.config;

//@Configuration
//public class WebMvcConfig implements WebMvcConfigurer {
//
//    /**
//     * ロガー
//     */
//    Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);
//
//    /**
//     * メールアドレス登録済みチェックオブジェクト
//     */
//    @Autowired
//    RegisteredCheck registeredCheck;
//
//    /**
//     * ユーザーオブジェクト
//     */
//    @Autowired
//    User user;


    /*
     * (非 Javadoc)
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#configurePathMatch(org.springframework.web.servlet.config.annotation.PathMatchConfigurer)
     */
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        UrlPathHelper urlPathHelper = new UrlPathHelper();
//        urlPathHelper.setRemoveSemicolonContent(false);
//        configurer.setUrlPathHelper(urlPathHelper);
//    }
//
//    @RequestMapping("registered_check/{emailAddress}")
//    @ResponseBody
//    boolean registeredCheck(@MatrixVariable("emailAddress") String emailAddress) {
//        logger.info("成功2");
//        user.setEmailAddress(emailAddress);
//        return registeredCheck.registeredCheck(user);
//    }
//}
