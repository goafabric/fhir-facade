package org.goafabric.fhir.adapter.remote.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Null
    private String id;
    
    @NotNull
    @Size(min = 3, max = 255)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 255)
    private String lastName;
}
