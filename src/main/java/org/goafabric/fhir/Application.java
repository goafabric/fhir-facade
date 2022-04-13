package org.goafabric.fhir;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Configuration
    static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Value("${security.authentication.enabled:true}") private Boolean isAuthenticationEnabled;

        @Override
        protected void configure(final HttpSecurity httpSecurity) throws Exception {
            if (isAuthenticationEnabled) { httpSecurity.authorizeRequests().anyRequest().authenticated().and().httpBasic(); }
            else { httpSecurity.authorizeRequests().anyRequest().permitAll(); }
        }
    }
}
