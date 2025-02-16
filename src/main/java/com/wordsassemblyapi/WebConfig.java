package com.wordsassemblyapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  /**
   * securityFilterChainクラス.
   */
  @Bean
  protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.csrf()
        .disable()
        .authorizeHttpRequests(authz -> authz
            .requestMatchers(HttpMethod.POST, "/v1/login").permitAll()
            .requestMatchers(HttpMethod.POST, "/v1/logout").permitAll()
            .requestMatchers(HttpMethod.POST, "/v1/authors").permitAll()
            .anyRequest().authenticated());

    return http.build();
  }
}
