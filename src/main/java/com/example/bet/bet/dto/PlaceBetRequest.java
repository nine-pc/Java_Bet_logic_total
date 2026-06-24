package com.example.bet.bet.dto;

import java.math.BigDecimal;
import java.util.List;

public record PlaceBetRequest(
    Long userId,
    BigDecimal stake,
    List<Long> outcomeIds
) {
}
