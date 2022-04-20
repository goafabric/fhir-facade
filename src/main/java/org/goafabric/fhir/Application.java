package org.goafabric.fhir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*
    @Configuration
    static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Value("${security.authentication.enabled:true}") private Boolean isAuthenticationEnabled;

        @Override
        protected void configure(final HttpSecurity httpSecurity) throws Exception {
            if (isAuthenticationEnabled) { httpSecurity.authorizeRequests().anyRequest().authenticated().and().httpBasic(); }
            else { httpSecurity.authorizeRequests().anyRequest().permitAll(); }
        }
    }

     */
}
