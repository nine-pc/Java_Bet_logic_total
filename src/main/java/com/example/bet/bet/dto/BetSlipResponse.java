package com.example.bet.bet.dto;

import com.example.bet.common.enums.BetStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BetSlipResponse(

        Long id,
        BigDecimal stake,
        BigDecimal totalOdds,
        BigDecimal potentialPayout,
        BetStatus status,
        LocalDateTime createdAt

) {
}
