package com.tui.ordering.pilotes.service;

import com.tui.ordering.pilotes.exception.PiloteNumberException;
import com.tui.ordering.pilotes.port.out.FindOrderPiloteValuesRepository;

import java.util.List;

public class ValidPilotesValuesService {

    private final FindOrderPiloteValuesRepository findOrderPiloteValuesRepository;

    public ValidPilotesValuesService(FindOrderPiloteValuesRepository findOrderPiloteValuesRepository) {
        this.findOrderPiloteValuesRepository = findOrderPiloteValuesRepository;
    }

    public void verify(int pilotes) {
        List<Integer> possibleValues = findOrderPiloteValuesRepository.findValues();
        if (!possibleValues.contains(pilotes)) {
            throw new PiloteNumberException();
        }
    }
}
