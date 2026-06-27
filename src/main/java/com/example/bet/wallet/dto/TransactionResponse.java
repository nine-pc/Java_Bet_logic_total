package com.example.bet.wallet.dto;

import com.example.bet.common.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionResponse(
        Long id,
        BigDecimal amount,
        TransactionType type,
        LocalDateTime createdAt
) {
}
