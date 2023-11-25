package com.tui.ordering.pilotes.port.out;

import com.tui.ordering.pilotes.model.Customer;

import java.util.Optional;

public interface FindClientRepository {
    Optional<Customer> findById(String userIdentifier);
}
