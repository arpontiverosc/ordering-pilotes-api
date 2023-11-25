package com.tui.ordering.pilotes.out.jpa.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class CustomerEntity {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<OrderEntity> orders;

}
