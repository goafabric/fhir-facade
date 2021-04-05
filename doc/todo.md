- client + tests einbauen
- builder für patient

- builder für search
                   
#spring native error
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'patientService' defined in class path resource [org/goafabric/example/fhir/service/PatientService.class]: Bean instantiation via constructor failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.goafabric.example.fhir.service.PatientService]: Constructor threw exception; nested exception is ca.uhn.fhir.context.ConfigurationException: Query parameter type ca.uhn.fhir.rest.param.StringParam has no constructor with types []
