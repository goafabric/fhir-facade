package org.goafabric.example.fhir.adapter;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@CircuitBreaker(name = "PersonService")
public class PersonServiceAdapter {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${adapter.personservice.url}/persons")
    private String serviceUrl;


    public Person getById(String id) {
        return restTemplate.getForObject(serviceUrl + "/getById/?id={id}",
                Person.class, id);
    }

    public List<Person> findAll() {
        return (List<Person>) restTemplate.getForObject(serviceUrl + "/findAll",
                List.class);
    }

    public List<Person> findByFirstName(String firstName) {
        return restTemplate.exchange(serviceUrl + "/findByFirstName?firstName={firstName}",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>(){}, firstName)
                .getBody();
    }

    public List<Person>findByLastName(String lastName) {
        return restTemplate.exchange(serviceUrl + "/findByLastName?lastName={lastName}",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Person>>(){}, lastName)
                .getBody();
    }

    public Boolean isAlive() {
        return restTemplate.getForObject(serviceUrl + "/isAlive", Boolean.class);
    }

}
