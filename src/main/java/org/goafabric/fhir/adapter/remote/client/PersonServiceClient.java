package org.goafabric.fhir.adapter.remote.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.goafabric.fhir.crossfunctional.BaseUrlBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Component
@Profile("remote")
@CircuitBreaker(name = "#{@baseUrlBean.getCBName()}")
public class PersonServiceClient {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BaseUrlBean baseUrlBean;

    public Person getById(String id) {
        return restTemplate.getForObject(getServiceUrl() + "/getById/?id={id}",
                Person.class, id);
    }

    public List<Person> findByFirstName(String firstName) {
        return restTemplate.exchange(getServiceUrl() + "/findByFirstName?firstName={firstName}",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>(){}, firstName)
                .getBody();
    }

    public List<Person> findByLastName(String lastName) {
        return restTemplate.exchange(getServiceUrl() + "/findByLastName?lastName={lastName}",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>(){}, lastName)
                .getBody();
    }

    public Person sayMyName(String name) {
        return restTemplate.getForObject(getServiceUrl() + "/sayMyName?name={name}", Person.class, name);
    }

    private String getServiceUrl() {
        final String baseUrl = baseUrlBean.getUrl() + "/persons";
        //log.info("calling {}", baseUrl);
        return baseUrl;
    }
}
