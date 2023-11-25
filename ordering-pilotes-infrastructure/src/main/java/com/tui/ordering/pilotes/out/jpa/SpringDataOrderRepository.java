package com.tui.ordering.pilotes.out.jpa;

import com.tui.ordering.pilotes.out.jpa.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface SpringDataOrderRepository extends JpaRepository<OrderEntity, String>, JpaSpecificationExecutor<OrderEntity> {
}
