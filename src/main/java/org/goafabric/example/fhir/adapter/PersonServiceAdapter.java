package org.goafabric.example.fhir.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
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
        return restTemplate.getForObject(serviceUrl + "/findAll",
                List.class);
    }

    public List<Person> findByFirstName(String firstName) {
        return restTemplate.getForObject(serviceUrl + "/findByFirstName?firstName={firstName}",
                List.class, firstName);
    }

    public List<Person>findByLastName(String lastName) {
        return restTemplate.getForObject(serviceUrl + "/findByLastName?lastName={lastName}",
                List.class, lastName);
    }

    public Boolean isAlive() {
        return restTemplate.getForObject(serviceUrl + "/isAlive", Boolean.class);
    }

}
