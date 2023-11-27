package com.tui.ordering.pilotes.mother;

import com.tui.ordering.pilotes.port.in.model.SearchOrderQuery;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchOrderQueryMother {
    public static SearchOrderQuery create() {
        return SearchOrderQuery.Builder.builder()
                .orderId("472bd97a-e744-4f40-9b14-159dc1881591")
                .customerLastName("LastName")
                .customerFirstName("FirstName")
                .customerId("1011")
                .pilotesNumber(5)
                .build();
    }
}
