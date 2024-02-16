package org.goafabric.fhir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*
    @Bean
    @ConditionalOnMissingClass("org.springframework.security.oauth2.client.OAuth2AuthorizationContext")
    public SecurityFilterChain filterChain(HttpSecurity http, @Value("${security.authentication.enabled:true}") Boolean isAuthenticationEnabled, HandlerMappingIntrospector introspector) throws Exception {
        return isAuthenticationEnabled
                ? http.authorizeHttpRequests(auth -> auth.requestMatchers(new MvcRequestMatcher(introspector, "/actuator/**")).permitAll().anyRequest().authenticated())
                .httpBasic(httpBasic -> {}).csrf(AbstractHttpConfigurer::disable).build()
                : http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll()).httpBasic(httpBasic -> {}).csrf(AbstractHttpConfigurer::disable).build();
    }

    @Bean
    ObservationPredicate disableHttpServerObservationsFromName() { return (name, context) -> !(name.startsWith("spring.security.") || (context instanceof ServerRequestObservationContext && ((ServerRequestObservationContext) context).getCarrier().getRequestURI().startsWith("/actuator"))); }}


     */
}