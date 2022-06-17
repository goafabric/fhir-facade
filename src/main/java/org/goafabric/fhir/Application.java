package org.goafabric.fhir;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Configuration @EnableWebSecurity
    static class SecurityConfiguration  {
        @Value("${security.authentication.enabled:true}")
        private Boolean isAuthenticationEnabled;

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            if (isAuthenticationEnabled) { http.authorizeRequests().anyRequest().authenticated().and().httpBasic().and().csrf().disable(); }
            else { http.authorizeRequests().anyRequest().permitAll(); }
            return http.build();
        }
    }
}
