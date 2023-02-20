package org.goafabric.fhir.adapter.mock;

import org.goafabric.fhir.adapter.PatientAdapter;
import org.goafabric.fhir.controller.dto.*;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static java.util.Arrays.asList;

@Profile("mock")
@Component
public class PatientMockAdapter implements PatientAdapter {
    public Patient getPatient(String id) {
        return createPatient(id);
    }

    @Override
    public Bundle findyFirstName(String firstName) {
        Bundle bundle = new Bundle();
        bundle.addEntry(createBundleEntry(createPatient("1"), "1"));
        return bundle;
    }

    @Override
    public Bundle findyByLastName(String lastName) {
        Bundle bundle = new Bundle();
        bundle.addEntry(createBundleEntry(createPatient("1"), "1"));
        return bundle;
    }

    @Override
    public void sayMyName(String homer) {
    }

    private Patient createPatient(String id) {
        return Patient.builder()
                .id(id)
                .name(Arrays.asList(createName()))
                .address(Arrays.asList(createAddress()))
                .telecom(Arrays.asList(createTelecom()))
                .build();
    }


    private HumanName createName() {
        //StringType family = new StringType("Simpson");//addExtension(Extension.builder().url("http://fhir.de/StructureDefinition/humanname-namenszusatz/0.2").valueString("The 3rd").build());

        var humanName = HumanName.builder()
                .given(Arrays.asList("Homer"))
                .family("Simpson")
                //.familyExtension(new ExtensionWrapper().addExtension("http://fhir.de/StructureDefinition/humanname-namenszusatz/0.2", "The 3rd"))
                .build();

        return humanName;
    }

    private Address createAddress() {
        return Address.builder()
                .id("42")
                .city("Springfield")
                .postalCode("78313")
                .country("US")
                .line(asList("Evergreen Terrace 742"))
                .use("home")
                .build();
    }

    public static Telecom createTelecom() {
        return Telecom.builder()
                .id("45")
                .system("phone")
                .use("home")
                .value("0245-33553")
                .build();
    }

    private Bundle.BundleEntryComponent createBundleEntry(Object resource, String id) {
        return Bundle.BundleEntryComponent.builder().resource(resource)
                .fullUrl(resource.getClass().getSimpleName() + "/" + id).build();
    }

}
