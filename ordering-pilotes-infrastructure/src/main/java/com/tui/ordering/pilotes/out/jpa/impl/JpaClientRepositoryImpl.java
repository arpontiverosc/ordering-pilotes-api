package com.tui.ordering.pilotes.out.jpa.impl;

import com.tui.ordering.pilotes.model.Client;
import com.tui.ordering.pilotes.out.jpa.SpringDataClientRepository;
import com.tui.ordering.pilotes.out.jpa.mapper.ClientMapper;
import com.tui.ordering.pilotes.port.out.FindClientRepository;

import java.util.Optional;

public class JpaClientRepositoryImpl implements FindClientRepository {

    private final SpringDataClientRepository springDataClientRepository;

    public JpaClientRepositoryImpl(SpringDataClientRepository springDataClientRepository) {
        this.springDataClientRepository = springDataClientRepository;
    }

    @Override
    public Optional<Client> findById(String userIdentifier) {
        return springDataClientRepository.findBy(userIdentifier);
    }
}
