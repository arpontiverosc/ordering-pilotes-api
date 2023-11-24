package com.tui.ordering.pilotes.out.jpa.mapper;

import com.tui.ordering.pilotes.model.Address;
import com.tui.ordering.pilotes.out.jpa.model.AddressEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AddressMapper {

    public static Address from(AddressEntity addressEntity) {
        return Address.Builder.builder()
                .addressId(addressEntity.getId())
                .city(addressEntity.getCity())
                .country(addressEntity.getCountry())
                .street(addressEntity.getStreet())
                .postcode(addressEntity.getPostcode())
                .build();
    }
}
