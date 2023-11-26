package com.tui.ordering.pilotes.out.jpa.model.security;


import jakarta.persistence.*;
import lombok.*;

@Entity(name = "authorities")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class AuthorityEntity {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    @Enumerated(EnumType.STRING)
    private AuthorityName name;

}
