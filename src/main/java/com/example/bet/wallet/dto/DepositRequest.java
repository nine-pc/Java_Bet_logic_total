package com.example.bet.wallet.dto;

import java.math.BigDecimal;

public record DepositRequest(
    Long userId,
    BigDecimal amount
) {
}
