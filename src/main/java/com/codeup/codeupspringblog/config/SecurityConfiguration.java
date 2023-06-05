package com.codeup.codeupspringblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws
            Exception {
        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/posts/create","/posts/comment", "/posts/**/edit").authenticated()
                        .requestMatchers("/posts").permitAll()
                        .requestMatchers("/css/**","/js/**").permitAll()
                                   );
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }

    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return null;
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return false;
            }
        };
    }

}
