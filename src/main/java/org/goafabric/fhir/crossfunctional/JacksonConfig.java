package org.goafabric.fhir.crossfunctional;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//JacksonConfig that tries to align XML Output with what (HAPI) FHIR Client expects the XML to look like
//Additionally Strings need to have a Value Field, this can be achieved with thr converter below but than breaks JSON
@Configuration
public class JacksonConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        //additionally all Strings need to be annotated with @JsonSerialize(converter = StringConverter.class) public String family;
        return builder -> builder.defaultUseWrapper(false) // unwrap xml lists
                .serializationInclusion(JsonInclude.Include.NON_NULL); // do not serialize null elements
    }
}
