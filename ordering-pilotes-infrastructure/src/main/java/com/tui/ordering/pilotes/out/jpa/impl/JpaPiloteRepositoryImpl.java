package com.tui.ordering.pilotes.out.jpa.impl;

import com.tui.ordering.pilotes.port.out.FindOrderPiloteValuesRepository;
import com.tui.ordering.pilotes.port.out.FindPilotePriceRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class JpaPiloteRepositoryImpl implements FindPilotePriceRepository, FindOrderPiloteValuesRepository {
    @Override
    public Optional<Double> getPrice() {
        return Optional.of(1.33);
    }

    @Override
    public List<Integer> findValues() {
        return Arrays.asList(5, 10, 15);
    }
}
