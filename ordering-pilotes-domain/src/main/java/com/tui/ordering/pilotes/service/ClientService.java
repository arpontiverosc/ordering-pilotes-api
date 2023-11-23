package com.tui.ordering.pilotes.service;

import com.tui.ordering.pilotes.exception.ClienteNotFoundException;
import com.tui.ordering.pilotes.model.Client;
import com.tui.ordering.pilotes.port.out.FindClientRepository;

public class ClientService {
    private final FindClientRepository findClientRepository;

    public ClientService(FindClientRepository findClientRepository) {
        this.findClientRepository = findClientRepository;
    }

    public Client retrieveClient(String userIdentifier) {
        return findClientRepository.findById(userIdentifier).orElseThrow(ClienteNotFoundException::new);
    }
}
