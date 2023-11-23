package com.tui.ordering.pilotes.service;

import com.tui.ordering.pilotes.exception.PriceNotFoundException;
import com.tui.ordering.pilotes.port.out.FindPilotePriceRepository;

public class ValidPilotesValuesService {

    private final FindPilotePriceRepository findPilotePriceRepository;

    public ValidPilotesValuesService(FindPilotePriceRepository findPilotePriceRepository) {
        this.findPilotePriceRepository = findPilotePriceRepository;
    }


    public void verify(int pilotes) {

    }
}
