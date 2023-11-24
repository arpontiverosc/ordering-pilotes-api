package com.tui.ordering.pilotes.out.jpa.impl;

import com.tui.ordering.pilotes.model.Client;
import com.tui.ordering.pilotes.out.jpa.SpringDataClientRepository;
import com.tui.ordering.pilotes.out.jpa.mapper.ClientMapper;
import com.tui.ordering.pilotes.port.out.FindClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaClientRepositoryImpl implements FindClientRepository {

    private final SpringDataClientRepository springDataClientRepository;

    @Override
    public Optional<Client> findById(String userIdentifier) {
        return springDataClientRepository.findById(userIdentifier).map(ClientMapper::from);
    }
}
