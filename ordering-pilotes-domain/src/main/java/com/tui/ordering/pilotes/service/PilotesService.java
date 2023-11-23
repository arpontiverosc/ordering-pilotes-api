package com.tui.ordering.pilotes.service;

import com.tui.ordering.pilotes.exception.PiloteNumberException;
import com.tui.ordering.pilotes.exception.PriceNotFoundException;
import com.tui.ordering.pilotes.port.out.FindOrderPiloteValuesRepository;
import com.tui.ordering.pilotes.port.out.FindPilotePriceRepository;

import java.util.List;

public class PilotesService {

    private final FindOrderPiloteValuesRepository findOrderPiloteValuesRepository;
    private final FindPilotePriceRepository findPilotePriceRepository;

    public PilotesService(FindOrderPiloteValuesRepository findOrderPiloteValuesRepository,
                          FindPilotePriceRepository findPilotePriceRepository) {
        this.findOrderPiloteValuesRepository = findOrderPiloteValuesRepository;
        this.findPilotePriceRepository = findPilotePriceRepository;
    }

    public double getPrice() {
        return findPilotePriceRepository.getPrice().orElseThrow(PriceNotFoundException::new);
    }

    public void validNumber(int pilotes) {
        List<Integer> possibleValues = findOrderPiloteValuesRepository.findValues();
        if (!possibleValues.contains(pilotes)) {
            throw new PiloteNumberException();
        }
    }
}
