package com.tui.ordering.pilotes.out.jpa.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class AddressEntity {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    @Column(name = "street")
    private String street;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;


}
