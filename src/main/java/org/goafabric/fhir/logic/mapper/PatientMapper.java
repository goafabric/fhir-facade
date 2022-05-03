package org.goafabric.fhir.logic.mapper;

import org.goafabric.fhir.adapter.Person;
import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.StringType;

import java.util.Arrays;
import java.util.List;

public class PatientMapper {
    public static List<Patient> map(List<Person> person) {
        return Arrays.asList(map(person.get(0)));
    }

    public static Patient map(Person person) {
        Patient patient = new Patient();
        patient.setId(person.getId());
        patient.setName(
                Arrays.asList(new HumanName()
                        .setGiven(Arrays.asList(new StringType(person.getFirstName())))
                        .setFamily(person.getLastName())
        ));

        final Address address = new Address();
        address.setCity("Springfield");
        address.setPostalCode("78313");
        //address.setLine()

        patient.setAddress(Arrays.asList(address));
        return patient;
    }
}
