package org.goafabric.example.fhir.adapter;

import lombok.extern.slf4j.Slf4j;
import org.goafabric.example.fhir.crossfunctional.BaseUrlBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
//@CircuitBreaker(name = "personservice")
@Slf4j
public class PersonServiceAdapter {

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
    
    private String getServiceUrl() {
        final String baseUrl = baseUrlBean.getUrl() + "/persons";
        log.info("calling {}", baseUrl);
        return baseUrl;
    }
}
