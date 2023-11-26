package com.tui.ordering.pilotes.out.jpa.impl;



import com.tui.ordering.pilotes.security.ConfigProperties;
import com.tui.ordering.pilotes.port.out.ConfigurationParamsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ConfigurationParamsRepositoryImpl implements ConfigurationParamsRepository {

    private final ConfigProperties configProperties;

    @Override
    public Optional<Integer> getTimeUpdatable() {
        return Optional.of(configProperties.getMinutes());
    }

    @Override
    public Optional<Double> getPrice() {
        return Optional.of(configProperties.getPilotePrice());
    }

    @Override
    public List<Integer> findValues() {
        return configProperties.getPilotesPossibleValue();
    }
}
