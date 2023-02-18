package org.goafabric.fhir.pojo.r4;

import ca.uhn.fhir.context.FhirContext;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.goafabric.fhir.adapter.mock.PatientMockAdapter;
import org.hl7.fhir.r4.model.Patient;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//https://www.baeldung.com/jackson-xml-serialization-and-deserialization
//https://github.com/FasterXML/jackson-dataformat-xml
public class XMLTests {
    @Test
    public void testXml() throws IOException {
        final String xml = getXml();

        Patient patient = (Patient) FhirContext.forR4().newXmlParser().parseResource(xml);
        assertThat(patient).isNotNull();

        //for this to work all Strings need @JsonSerialize(converter = StringConverter.class)
        //assertThat(patient.getName().get(0).getFamily()).isEqualTo("Simpson");
        //assertThat(patient.getName().get(0).getGiven().get(0).getValue()).isEqualTo("Homer");
    }

    private static String getXml() throws JsonProcessingException {
        var xmlMapper = XmlMapper.builder()
                //has to be in line with JacksonConfig Configuration
                .defaultUseWrapper(false)
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                .build();

        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String xml = xmlMapper.writeValueAsString(new PatientMockAdapter().getPatient("1"));
        System.err.println(xml);
        return xml;
    }
}
