package com.example.bet.wallet.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionResponse(
        Long id,
        BigDecimal amount,
        String type,
        LocalDateTime createdAt
) {
}
