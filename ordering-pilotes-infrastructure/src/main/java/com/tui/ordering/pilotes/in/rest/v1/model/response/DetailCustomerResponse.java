package com.tui.ordering.pilotes.in.rest.v1.model.response;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DetailCustomerResponse {

    private final String id;

    private final String firstName;

    private final String lastName;
}
