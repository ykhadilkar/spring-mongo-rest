package com.example.accessingmongodbdatarest;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "includeId", types = { Person.class })
interface IncludeId {
    String getId();
    String getFirstName();
    String getLastName();
    String getEmail();
}
