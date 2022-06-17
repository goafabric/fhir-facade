package org.goafabric.fhir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Configuration @EnableWebSecurity
    @ConditionalOnProperty(value = "security.authentication.enabled", matchIfMissing = true)
    static class SecurityConfiguration {

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.authorizeRequests().anyRequest().authenticated().and().httpBasic()
                    .and().formLogin().disable()
                    .csrf().disable();
            return http.build();
        }
    }
}
