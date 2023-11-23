package com.tui.ordering.pilotes.out.jpa.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

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

    @Column(name = "user_id")
    private String userIdentifier;

    @Column(name = "delivery_address")
    private AddressEntity deliveryAddress;

    @Column(name = "pilotes")
    private int pilotes;

    @Column(name = "orderTotal")
    private double orderTotal;


}
