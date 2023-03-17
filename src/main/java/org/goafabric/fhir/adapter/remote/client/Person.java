package org.goafabric.fhir.adapter.remote.client;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

public record Person(
    @Null String id,
    @NotNull @Size(min = 3, max = 255) String firstName,
    @NotNull @Size(min = 3, max = 255) String lastName
) {}
