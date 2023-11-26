package com.tui.ordering.pilotes.port.out;

import java.util.List;
import java.util.Optional;

public interface ConfigurationParamsRepository {
    Optional<Integer> getTimeUpdatable();

    Optional<Double> getPrice();

    List<Integer> findValues();
}
