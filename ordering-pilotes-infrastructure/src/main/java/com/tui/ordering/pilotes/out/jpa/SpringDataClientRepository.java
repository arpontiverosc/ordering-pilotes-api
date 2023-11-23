package com.tui.ordering.pilotes.out.jpa;

import com.tui.ordering.pilotes.out.jpa.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataClientRepository extends JpaRepository<ClientEntity, String> {
}
