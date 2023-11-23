package com.tui.ordering.pilotes.service;

import com.tui.ordering.pilotes.exception.PriceNotFoundException;
import com.tui.ordering.pilotes.port.out.FindPilotePriceRepository;

public class FindPilotePriceService {

    private final FindPilotePriceRepository findPilotePriceRepository;

    public FindPilotePriceService(FindPilotePriceRepository findPilotePriceRepository) {
        this.findPilotePriceRepository = findPilotePriceRepository;
    }

    public double getPrice() {
        return findPilotePriceRepository.getPrice().orElseThrow(PriceNotFoundException::new);
    }
}
