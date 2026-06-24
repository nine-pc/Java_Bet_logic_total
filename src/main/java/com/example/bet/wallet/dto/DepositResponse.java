package com.example.bet.wallet.dto;

import java.math.BigDecimal;

public record DepositResponse(
    Long userId,
    BigDecimal newBalance
) {
}
