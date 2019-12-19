package com.koikeya.project1.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.koikeya.project1.app.controller.AuthenticationFailureHandlerImpl;



/**
 * Spring Security設定クラス
 * @author Yuki Koike
 */
@Configuration
// @EnableWebSecurityを付与して、Spring SecurityのWeb連携機能（CSRF対策など）を有効にする
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Bean設定オブジェクト
     */
    static ApplicationContext ac;

    /**
     * パスワード符号化用オブジェクト
     */
    static PasswordEncoder passwordEncoder;

    /**
     * ???
     */
    static AuthenticationEntryPoint aep;

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
     * パスワード符号化用オブジェクトを返す
     *
     * @return BCryptPasswordEncoderオブジェクト
     */
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    AuthenticationEntryPoint authenticationEntryPoint() {
//        return new SessionExpiredDetectingLoginUrlAuthenticationEntryPoint("/login");
//    }

    /**
     * staticイニシャライザ
     */
    static {
        ac = new AnnotationConfigApplicationContext(AppConfig.class);
        passwordEncoder = ac.getBean(PasswordEncoder.class);
        aep = ac.getBean(AuthenticationEntryPoint.class);
    }

    /*
     * (非 Javadoc)
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//        PasswordEncoder pe =ac.getBean(PasswordEncoder.class);

        httpSecurity.authorizeRequests().antMatchers("**", "**/**", "/css/**", "/images/**", "/js/**", "/webjars/**")
          .permitAll().antMatchers("/login/", "login/**").permitAll().anyRequest().authenticated().and()
          .formLogin().loginProcessingUrl("/login/**").loginPage("/login_index")
          .successHandler(authenticationSucessHandlerImpl)
//           .defaultSuccessUrl("/index")
//          .defaultSuccessUrl("/")
//          .failureUrl("/login_index?error=true").permitAll()
          .failureHandler(new AuthenticationFailureHandlerImpl()).permitAll()
          .and().logout()// .permitAll()
          .and().exceptionHandling().authenticationEntryPoint(aep);//.logoutSuccessUrl("/login").permitAll()

    }

    /*
     * (非 Javadoc)
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}
