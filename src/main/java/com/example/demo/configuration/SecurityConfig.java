package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailService customUserDetailService;

    @Autowired
    public SecurityConfig(CustomUserDetailService CustomUserDetailService) {
        this.customUserDetailService = CustomUserDetailService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService UserDetailsService(UserRepository userRep) {
        return new CustomUserDetailService(userRep);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .userDetailsService(customUserDetailService)
                .authorizeRequests()
                .antMatchers("/api/users/register").permitAll()
                .antMatchers("/api/movies/**").authenticated()
                .and()
                .httpBasic();
        http.csrf().disable();
    }

}