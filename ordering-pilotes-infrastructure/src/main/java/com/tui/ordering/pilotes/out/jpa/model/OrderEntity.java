package com.tui.ordering.pilotes.out.jpa.model;



import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name="orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class OrderEntity {
    @Id

    @EqualsAndHashCode.Include
    private Long id;

    @Column(name="brand_id")
    private Long brandId;

    @Column(name="start_date")
    private LocalDateTime startDate;

    @Column(name="end_date")
    private LocalDateTime endDate;

    @Column(name="price_list")
    private Long priceList;

    @Column(name="product_id")
    private Long productId;

    @Column(name="price")
    private BigDecimal price;

    @Column(name="curr")
    private String curr;

    @Column(name="priority")
    private Long priority;


}
