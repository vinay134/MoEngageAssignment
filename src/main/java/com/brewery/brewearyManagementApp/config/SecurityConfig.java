package com.brewery.brewearyManagementApp.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(http->http.disable());
        return httpSecurity.authorizeHttpRequests(auth->auth
                .requestMatchers("/signup").permitAll()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/home").authenticated()
                .requestMatchers("/search").authenticated()
                .requestMatchers("/show-details/**").authenticated()
                .requestMatchers("/submit-rating").authenticated()
        ).formLogin(loginPage->loginPage.loginPage("/login")
                .defaultSuccessUrl("/home").permitAll()).build();
    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.build();
    }
}
