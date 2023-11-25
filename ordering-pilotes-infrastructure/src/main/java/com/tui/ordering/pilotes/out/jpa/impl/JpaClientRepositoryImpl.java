package com.tui.ordering.pilotes.out.jpa.impl;

import com.tui.ordering.pilotes.model.Customer;
import com.tui.ordering.pilotes.out.jpa.SpringDataCustomerRepository;
import com.tui.ordering.pilotes.out.jpa.mapper.ClientMapper;
import com.tui.ordering.pilotes.port.out.FindClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaClientRepositoryImpl implements FindClientRepository {

    private final SpringDataCustomerRepository springDataClientRepository;

    @Override
    public Optional<Customer> findById(String userIdentifier) {
        return springDataClientRepository.findById(userIdentifier).map(ClientMapper::from);
    }
}
