package com.tui.ordering.pilotes.mother;

import com.tui.ordering.pilotes.in.rest.v1.model.request.OrderAddress;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderAddressMother {

    public static OrderAddress create(){
        return OrderAddress.builder()
                .city("Madrid")
                .street("Gran vía, 32")
                .postcode("28820")
                .country("Spain")
                .build();
    }

    public static OrderAddress createChanged(){
        return OrderAddress.builder()
                .city("Madrid changed")
                .street("Gran vía, 32 changed")
                .postcode("11111")
                .country("Spain changed")
                .build();
    }
}
