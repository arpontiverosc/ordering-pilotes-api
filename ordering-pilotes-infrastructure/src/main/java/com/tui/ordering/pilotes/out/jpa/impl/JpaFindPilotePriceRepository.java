package com.tui.ordering.pilotes.out.jpa.impl;

import com.tui.ordering.pilotes.port.out.FindPilotePriceRepository;

import java.util.Optional;

public class JpaFindPilotePriceRepository implements FindPilotePriceRepository {
    @Override
    public Optional<Double> getPrice() {
        return Optional.empty();
    }
}
