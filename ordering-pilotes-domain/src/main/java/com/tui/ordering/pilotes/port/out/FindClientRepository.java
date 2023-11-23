package com.tui.ordering.pilotes.port.out;

import com.tui.ordering.pilotes.model.Client;

import java.util.Optional;

public interface FindClientRepository {
    Optional<Client> findById(String userIdentifier);
}
