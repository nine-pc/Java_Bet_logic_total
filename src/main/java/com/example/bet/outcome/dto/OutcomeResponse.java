package com.example.bet.outcome.dto;

import java.math.BigDecimal;

public record OutcomeResponse(

        Long id,

        Long marketId,

        String name,

        BigDecimal odds,

        Boolean active
) {
}
