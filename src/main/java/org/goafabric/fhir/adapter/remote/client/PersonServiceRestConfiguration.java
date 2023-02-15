package org.goafabric.fhir.adapter.remote.client;

import org.goafabric.fhir.crossfunctional.BaseUrlBean;
import org.goafabric.fhir.crossfunctional.HttpInterceptor;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.Base64;
import java.util.Collections;

@Configuration
@Profile("remote")
@ImportRuntimeHints(PersonServiceRestConfiguration.ApplicationRuntimeHints.class)
@RegisterReflectionForBinding(Person.class)
public class PersonServiceRestConfiguration {
    @Bean
    public RestTemplate restTemplateTest(
        @Value("${adapter.personservice.user}") String user,
        @Value("${adapter.personservice.password}") String password,
        @Value("${adapter.timeout}") Integer timeout) {
        final RestTemplate restTemplate = new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(timeout))
                .setReadTimeout(Duration.ofMillis(timeout))
                .build();

        restTemplate.setMessageConverters(Collections.singletonList(new MappingJackson2HttpMessageConverter()));
        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            request.getHeaders().setBasicAuth(
                    new String(Base64.getDecoder().decode(user)), new String(Base64.getDecoder().decode(password)));
            request.getHeaders().set("X-TenantId", HttpInterceptor.getTenantId());
            request.getHeaders().set("X-Auth-Request-Preferred-Username", HttpInterceptor.getUserName());
            return execution.execute(request, body);
        });
        return restTemplate;
    }

    static class ApplicationRuntimeHints implements RuntimeHintsRegistrar {
        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            hints.reflection().registerType(io.github.resilience4j.spring6.circuitbreaker.configure.CircuitBreakerAspect.class,
                    builder -> builder.withMembers(MemberCategory.INVOKE_DECLARED_METHODS));
            hints.reflection().registerType(BaseUrlBean.class, //needed for spel epxression inside CircuitBreaker
                    builder -> builder.withMembers(MemberCategory.INVOKE_DECLARED_METHODS));
        }
    }

}
