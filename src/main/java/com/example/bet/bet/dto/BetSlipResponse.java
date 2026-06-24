package com.example.bet.bet.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BetSlipResponse(

        Long id,
        BigDecimal stake,
        BigDecimal totalOdds,
        BigDecimal potentialPayout,
        String status,
        LocalDateTime createdAt

) {
}
