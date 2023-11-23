package com.tui.ordering.pilotes.out.jpa.mapper;


import com.tui.ordering.pilotes.model.Client;
import com.tui.ordering.pilotes.out.jpa.model.ClientEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientMapper {

  public static Client from(ClientEntity clientEntity) {
    return Client.Builder.builder()
            .clientId(clientEntity.getId())
            .firstName(clientEntity.getFirstName())
            .lastName(clientEntity.getLastName())
            .build();
  }

}
