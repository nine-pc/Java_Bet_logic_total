package com.example.bet.bet.dto;

import java.math.BigDecimal;

public record PlaceBetResponse(
    Long betSlipId,
    BigDecimal totalOdds,
    BigDecimal potentialPayout
) {
}
