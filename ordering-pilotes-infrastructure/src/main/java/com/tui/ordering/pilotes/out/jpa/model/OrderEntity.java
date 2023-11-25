package com.tui.ordering.pilotes.out.jpa.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Entity(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class OrderEntity {

    @Id
    @EqualsAndHashCode.Include
    private String orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private CustomerEntity customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deliveryAddress_id", referencedColumnName = "id", nullable = false)
    private AddressEntity deliveryAddress;

    @Column(name = "pilotes_number")
    private int pilotesNumber;

    @Column(name = "order_total")
    private double orderTotal;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

}
