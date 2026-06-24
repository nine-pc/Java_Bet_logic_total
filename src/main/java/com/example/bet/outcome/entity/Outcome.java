package com.example.bet.outcome.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("outcomes")
public record Outcome(

        @Id
        Long id,

        Long marketId,

        String name,

        BigDecimal odds,

        Boolean active
) {
}
