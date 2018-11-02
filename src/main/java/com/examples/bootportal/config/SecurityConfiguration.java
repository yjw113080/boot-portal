package com.examples.bootportal.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure (HttpSecurity http) throws Exception {
        http
            .logout() // logout설정을 한다.
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/device").and()
            .authorizeRequests() // path별 접근설정, 위에서 부터 체크 순서가 중요.
                .antMatchers("/members/joinform").permitAll()
                .antMatchers(HttpMethod.POST,"/members/join").permitAll()
                .antMatchers("/members/welcome").permitAll()
                .antMatchers("/members/login").permitAll()
                .antMatchers("/members/**").hasRole("USER")
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().fullyAuthenticated().and()
            .headers()
                .frameOptions().disable().and()
            .csrf()
                .ignoringAntMatchers("/**")
            .and()
                .formLogin() // 로그인 설정
                    .loginPage("/login")
                       .usernameParameter("email")
                        .passwordParameter("password")
                .loginProcessingUrl("/login");
    }
}
