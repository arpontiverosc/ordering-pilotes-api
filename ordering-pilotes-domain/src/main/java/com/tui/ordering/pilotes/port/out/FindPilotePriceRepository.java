package com.tui.ordering.pilotes.port.out;

import java.util.Optional;

public interface FindPilotePriceRepository {
    Optional<Double> getPrice();
}
