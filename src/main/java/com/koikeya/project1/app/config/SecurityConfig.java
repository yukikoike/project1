package com.koikeya.project1.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.koikeya.project1.app.controller.AuthenticationFailureHandlerImpl;
import com.koikeya.project1.app.controller.SessionExpiredDetectingLoginUrlAuthenticationEntryPoint;



/**
 * Spring Security設定クラス
 * @author Yuki Koike
 */
@Configuration
// @EnableWebSecurityを付与して、Spring SecurityのWeb連携機能（CSRF対策など）を有効にする
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * UserDetailsService
     */
    @Autowired
    UserDetailsService userDetailsService;

    /**
     *AuthenticationSucessHandler
     */
    @Autowired
    AuthenticationSuccessHandler authenticationSucessHandlerImpl;


    /**
     * パスワード符号化用オブジェクトを返す1
     *
     * @return BCryptPasswordEncoderオブジェクト
     */
    @Bean
    PasswordEncoder passwordEncoder1() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationEntryPoint authenticationEntryPoint() {
        return new SessionExpiredDetectingLoginUrlAuthenticationEntryPoint("/login");
    }


    /*
     * (非 Javadoc)
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("**", "**/**", "/css/**", "/images/**", "/js/**", "/webjars/**")
          .permitAll().antMatchers("/login/", "login/**").permitAll().anyRequest().authenticated().and()
          .formLogin().loginProcessingUrl("/login/**").loginPage("/login_index")
          .successHandler(authenticationSucessHandlerImpl)
//           .defaultSuccessUrl("/index")
//          .defaultSuccessUrl("/")
//          .failureUrl("/login_index?error=true").permitAll()
          .failureHandler(new AuthenticationFailureHandlerImpl()).permitAll()
          .and().logout()// .permitAll()
          .and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint());//.logoutSuccessUrl("/login").permitAll()

    }

    /*
     * (非 Javadoc)
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder1());
    }
}
