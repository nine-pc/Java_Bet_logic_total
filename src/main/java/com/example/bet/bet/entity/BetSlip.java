package com.example.bet.bet.entity;

import com.example.bet.common.enums.BetStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table("bet_slips")
public record BetSlip(

        @Id
        Long id,

        Long userId,

        BigDecimal stake,

        BigDecimal totalOdds,

        BigDecimal potentialPayout,

        BetStatus status,

        LocalDateTime createdAt
) {
}
