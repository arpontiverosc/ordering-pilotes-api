package com.tui.ordering.pilotes.mother;


import com.tui.ordering.pilotes.port.in.model.OrderAddress;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderAddressMother {

    public static OrderAddress create(){
        return OrderAddress.Builder.builder()
                .city("Madrid")
                .street("Gran vía, 32")
                .postcode("28820")
                .country("Spain")
                .build();
    }
}
