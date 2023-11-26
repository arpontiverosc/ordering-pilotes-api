package com.tui.ordering.pilotes.service;

import com.tui.ordering.pilotes.exception.PiloteNumberException;
import com.tui.ordering.pilotes.exception.PriceNotFoundException;
import com.tui.ordering.pilotes.port.out.ConfigurationParamsRepository;

import java.util.List;

public class PilotesService {
    private final ConfigurationParamsRepository configurationParamsRepository;

    public PilotesService(ConfigurationParamsRepository configurationParamsRepository) {
        this.configurationParamsRepository = configurationParamsRepository;
    }

    public Double getPrice() {
        return configurationParamsRepository.getPrice().orElseThrow(PriceNotFoundException::new);
    }

    public void validNumber(int pilotes) {
        List<Integer> possibleValues = configurationParamsRepository.findValues();
        if (!possibleValues.contains(pilotes)) {
            throw new PiloteNumberException();
        }
    }
}
