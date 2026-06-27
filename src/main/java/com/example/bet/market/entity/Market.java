package com.example.bet.market.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("markets")
public record Market(
        @Id
        Long id,

        Long eventId,

        String name
) {
}
