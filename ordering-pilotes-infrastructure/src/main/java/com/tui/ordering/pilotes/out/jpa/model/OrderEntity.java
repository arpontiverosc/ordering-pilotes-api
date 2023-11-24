package com.tui.ordering.pilotes.out.jpa.model;


import jakarta.persistence.*;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deliveryAddress_id", referencedColumnName = "id", nullable = false)
    private AddressEntity deliveryAddress;

    @Column(name = "pilotes")
    private int pilotes;

    @Column(name = "orderTotal")
    private double orderTotal;


}
