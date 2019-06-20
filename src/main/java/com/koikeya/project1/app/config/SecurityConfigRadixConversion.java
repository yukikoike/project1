//package com.koikeya.project1.app.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//
///**
// * Spring Security設定クラス
// * @author Yuki Koike
// */
//@Configuration
//// @EnableWebSecurityを付与して、Spring SecurityのWeb連携機能（CSRF対策など）を有効にする
//@EnableWebSecurity
//@Order(2)
//public class SecurityConfigRadixConversion extends WebSecurityConfigurerAdapter {
//
//    /**
//     * UserDetailsService
//     */
//    @Autowired
//    UserDetailsService userDetailsService;
//
//    /**
//     *AuthenticationSucessHandler
//     */
//    @Autowired
//    AuthenticationSuccessHandler authenticationSucessHandlerImpl;
//
//    /**
//     * パスワード符号化用オブジェクトを返す2
//     *
//     * @return BCryptPasswordEncoderオブジェクト
//     */
//    @Bean
//    PasswordEncoder passwordEncoder2() {
//        return new BCryptPasswordEncoder();
//    }
//
//    /*
//     * (非 Javadoc)
//     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
//     */
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.authorizeRequests().antMatchers("**", "**/**", "/css/**", "/images/**", "/js/**", "/webjars/**")
//          .permitAll().anyRequest().authenticated().and()
//          .formLogin().loginProcessingUrl("/radix_conversion/login").loginPage("/login_radix_conversion")
////          .successHandler(authenticationSucessHandlerImpl)
//          .defaultSuccessUrl("/radix_conversion")
//          .failureUrl("/login_radix_conversion?error=true").permitAll()
//          .and().logout().logoutSuccessUrl("/login_index").permitAll();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder2());
//    }
//}
