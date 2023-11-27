package com.tui.ordering.pilotes.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.http.HttpMethod;
import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
@Configuration
public class WebSecurityConfig {

    private static final String[] AUTH_WHITE_LIST = {
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/v2/api-docs/**",
            "/swagger-resources/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .httpBasic()
                .and().authorizeHttpRequests()
                .requestMatchers(AUTH_WHITE_LIST).permitAll()
                .requestMatchers(toH2Console()).permitAll()
                .requestMatchers(HttpMethod.POST, "/v1/orders").permitAll()
                .requestMatchers(HttpMethod.PUT, "/v1/orders/{orderId}").permitAll()
                .requestMatchers(HttpMethod.GET, "/v1/orders").authenticated()
                .requestMatchers(HttpMethod.GET, "/v1/orders") .hasRole("READ")
                .and()
                .build();
    }

    @Bean
   public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
