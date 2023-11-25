package com.tui.ordering.pilotes.out.jpa.mapper;


import com.tui.ordering.pilotes.model.Customer;
import com.tui.ordering.pilotes.out.jpa.model.CustomerEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientMapper {

  public static Customer from(CustomerEntity customerEntity) {
    return Customer.Builder.builder()
            .customerId(customerEntity.getId())
            .firstName(customerEntity.getFirstName())
            .lastName(customerEntity.getLastName())
            .build();
  }

}
