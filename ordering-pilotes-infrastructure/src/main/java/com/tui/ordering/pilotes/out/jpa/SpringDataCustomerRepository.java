package com.tui.ordering.pilotes.out.jpa;

import com.tui.ordering.pilotes.out.jpa.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCustomerRepository extends JpaRepository<CustomerEntity, String> {
}
